package rs.uns.ac.ftn.cdss.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import org.drools.core.ClassObjectFilter;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.uns.ac.ftn.cdss.CdssSpringAppApplication;
import rs.uns.ac.ftn.cdss.dto.AllergiesDto;
import rs.uns.ac.ftn.cdss.dto.RecordDto;
import rs.uns.ac.ftn.cdss.dto.SymptomDto;
import rs.uns.ac.ftn.cdss.model.Disease;
import rs.uns.ac.ftn.cdss.model.Medicine;
import rs.uns.ac.ftn.cdss.model.MedicineComponent;
import rs.uns.ac.ftn.cdss.model.Patient;
import rs.uns.ac.ftn.cdss.model.Record;
import rs.uns.ac.ftn.cdss.model.Symptom;
import rs.uns.ac.ftn.cdss.model.User;
import rs.uns.ac.ftn.cdss.repository.DiseaseRepository;
import rs.uns.ac.ftn.cdss.repository.MedicineRepository;
import rs.uns.ac.ftn.cdss.repository.PatientRepository;
import rs.uns.ac.ftn.cdss.repository.RecordRepository;
import rs.uns.ac.ftn.cdss.repository.SymptomRepository;
import rs.uns.ac.ftn.cdss.repository.UserRepository;
import rs.uns.ac.ftn.cdss.service.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	PatientRepository patientRepository;

	@Autowired
	DiseaseRepository diseaseRepository;

	@Autowired
	MedicineRepository medicineRepository;

	@Autowired
	SymptomRepository symptomRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RecordRepository recordRepository; 

	@Override
	public AllergiesDto makeDiagnose(Long id, RecordDto newRecord, String username) {

		KieSession kieSession = CdssSpringAppApplication.kieSessions.get(username);
		if (kieSession == null)
			return null;

		Patient p = patientRepository.getOne(id);
		if (p == null)
			return null;
		
		User doctor = userRepository.getByUsername(username);
		

		Record record = new Record();
		record.setDate(new Date());
		record.setDisease(diseaseRepository.findByName(newRecord.getDisease().getName()));
		record.setDoctor(doctor);
		
		record.setMedicine(new ArrayList<Medicine>());
		for (String mString : newRecord.getMedicnie()) {
			Medicine m = medicineRepository.findByName(mString);
			record.getMedicine().add(m);
		}

		record.setSymptoms(new ArrayList<Symptom>());
		for (SymptomDto sDto : newRecord.getSymptoms()) {
			Symptom s = symptomRepository.findByName(sDto.getName());
			if (s.getName().equals("Temperatura"))
				s.setValue(sDto.getValue());
			record.getSymptoms().add(s);
		}
		
		//Ako sam uspesno prosao kontrolu\
		AllergiesDto a = checkAllergies(p, record.getMedicine(), kieSession);
		if (a.isSucces()) {
			Record r = recordRepository.saveAndFlush(record);
			p.getPatientHistory().add(r);
			patientRepository.save(p);
			return a;
		}else {
			return a;
		}
		
	}

	@SuppressWarnings("unchecked")
	public AllergiesDto checkAllergies(Patient p, Collection<Medicine> medicines, KieSession kieSession) {

		kieSession.setGlobal("pId", p.getId());
		kieSession.insert(p);

		for (Medicine m : medicines) {
			kieSession.insert(m);
			for (MedicineComponent mc : m.getComponents())
				kieSession.insert(mc);
		}
		kieSession.getAgenda().getAgendaGroup("allergies").setFocus();
		kieSession.fireAllRules();
		Collection<String> allergiesFound = (Collection<String>) kieSession
				.getObjects(new ClassObjectFilter(String.class));
		Iterator<String> iterMed = allergiesFound.iterator();
		int mCounter = 0;
		AllergiesDto all = new AllergiesDto();
		all.setAllergies(new ArrayList<String>());
		while (iterMed.hasNext()) {
			all.getAllergies().add(iterMed.next());
			mCounter++;
		}

		boolean alright = true;
		if (mCounter != 0)
			alright = false;
		release(kieSession);
		all.setSucces(alright);
		return all;

	}

	public void release(KieSession kieSession) {
		kieSession.getObjects();

		for (Object object : kieSession.getObjects()) {
			if (!object.getClass().equals(Disease.class))
				kieSession.delete(kieSession.getFactHandle(object));
		}
	}

}
