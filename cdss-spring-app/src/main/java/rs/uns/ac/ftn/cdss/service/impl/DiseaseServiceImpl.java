package rs.uns.ac.ftn.cdss.service.impl;

import java.util.ArrayList;
import java.util.Collection;

import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.uns.ac.ftn.cdss.CdssSpringAppApplication;
import rs.uns.ac.ftn.cdss.model.DateChecker;
import rs.uns.ac.ftn.cdss.model.Disease;
import rs.uns.ac.ftn.cdss.model.Patient;
import rs.uns.ac.ftn.cdss.model.Record;
import rs.uns.ac.ftn.cdss.model.Symptom;
import rs.uns.ac.ftn.cdss.model.util.SalienceChecker;
import rs.uns.ac.ftn.cdss.repository.PatientRepository;
import rs.uns.ac.ftn.cdss.repository.SymptomRepository;
import rs.uns.ac.ftn.cdss.service.DiseaseService;

@Service
public class DiseaseServiceImpl implements DiseaseService {

	@Autowired
	SymptomRepository symptomRepository;

	@Autowired
	PatientRepository patientRepository;

	@Override
	public Record getDiseaseBySymptoms(Long id, ArrayList<Symptom> symptoms, String username) {

		// Iz mape kie sesijadobavi onu koja pripada ulogovanom doktoru
		KieSession kieSession = CdssSpringAppApplication.kieSessions.get(username);

		kieSession.insert(new DateChecker());
		kieSession.insert(new SalienceChecker());

		// Pokusaj da nadjes pacijenta
		Patient patient = patientRepository.getOne(id);

		kieSession.insert(patient);

		Collection<Record> patientRecord = patient.getPatientHistory();
		for (Record r : patientRecord) {
			kieSession.insert(r);
		}

		Record newRecord = new Record();
		if (symptoms.equals(null)) {
			newRecord.setSymptoms(new ArrayList<Symptom>());
		} else {
			newRecord.setSymptoms(symptoms);
		}
		newRecord.setDisease(null);

		kieSession.insert(newRecord);

		kieSession.getAgenda().getAgendaGroup("diseases-group").setFocus();
		kieSession.fireAllRules();

		release(kieSession);
		if (newRecord.getDisease() != null) {
			System.err.println("Pronasli smo bolest: ");
			System.err.println(newRecord.getDisease().toString());
		}
		// TODO Auto-generated method stub
		return newRecord;
	}

	public void release(KieSession kieSession) {
		for (Object object : kieSession.getObjects()) {
			if (!object.getClass().equals(Disease.class))
				kieSession.delete(kieSession.getFactHandle(object));
		}
	}

}
