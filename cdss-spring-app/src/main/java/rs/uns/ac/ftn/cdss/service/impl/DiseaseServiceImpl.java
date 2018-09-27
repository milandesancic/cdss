package rs.uns.ac.ftn.cdss.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.QueryResults;
import org.kie.api.runtime.rule.QueryResultsRow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.uns.ac.ftn.cdss.CdssSpringAppApplication;
import rs.uns.ac.ftn.cdss.model.Disease;
import rs.uns.ac.ftn.cdss.model.Patient;
import rs.uns.ac.ftn.cdss.model.Record;
import rs.uns.ac.ftn.cdss.model.Symptom;
import rs.uns.ac.ftn.cdss.model.User;
import rs.uns.ac.ftn.cdss.model.UserRole;
import rs.uns.ac.ftn.cdss.model.util.DateChecker;
import rs.uns.ac.ftn.cdss.model.util.SalienceChecker;
import rs.uns.ac.ftn.cdss.repository.DiseaseRepository;
import rs.uns.ac.ftn.cdss.repository.PatientRepository;
import rs.uns.ac.ftn.cdss.repository.SymptomRepository;
import rs.uns.ac.ftn.cdss.repository.UserRepository;
import rs.uns.ac.ftn.cdss.service.DiseaseService;

@Service
public class DiseaseServiceImpl implements DiseaseService {

	@Autowired
	SymptomRepository symptomRepository;

	@Autowired
	PatientRepository patientRepository;
	
	@Autowired
	DiseaseRepository diseaseRepository;
	
	@Autowired
	UserRepository userRepository;

	@Override
	public Disease getDiseaseBySymptoms(Long id, ArrayList<Symptom> symptoms, String username) {

		// Iz mape kie sesijadobavi onu koja pripada ulogovanom doktoru
		KieSession kieSession = CdssSpringAppApplication.kieSessions.get(username);

		kieSession.insert(new DateChecker());
		kieSession.insert(new SalienceChecker());

		// Pokusaj da nadjes pacijenta
		Patient patient = patientRepository.getOne(id);
		if(patient==null) {
			return null;
		}
		kieSession.insert(patient);

		Collection<Record> patientRecord = patient.getPatientHistory();
		for (Record r : patientRecord) {
//			System.out.println(r.getDate());
//			System.out.println(r.getDisease());
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
			System.out.println(newRecord.getDisease().toString());
		}
		return newRecord.getDisease();
	}
	

	@Override
	public ArrayList<Disease> getDiseaseFromQuery(ArrayList<Symptom> symptoms, String username) {
		KieSession kieSession = CdssSpringAppApplication.kieSessions.get(username);
		if (kieSession ==  null) {
			return null;
		}
		QueryResults results = kieSession.getQueryResults( "Bolesti po simptomima", new Object[] { symptoms } );
		System.out.println( "Pronadjeno: " + results.size()+" bolesti!");
		
		Map<Disease, Long> map = new HashMap<>();
		for ( QueryResultsRow row : results ) {
		    Disease disease = ( Disease ) row.get("disease");
		    Long num = (Long) row.get("numOfSym");
		    map.put(disease, num);
		    System.err.println("Disease: "+disease.getName()+"  numOfSym: "+num);
		}
		
		Map<Disease, Long> result = map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
		
		ArrayList<Disease> relatedDiseases= new ArrayList<>();
		for(Disease d: result.keySet()) {
			relatedDiseases.add(d);
		}
		release(kieSession);
		return relatedDiseases;
		
		
	}

	public void release(KieSession kieSession) {
		for (Object object : kieSession.getObjects()) {
			if (!object.getClass().equals(Disease.class))
				kieSession.delete(kieSession.getFactHandle(object));
		}
	}


	@Override
	public List<Disease> getAll() {
		return this.diseaseRepository.findAll();
	}


	@Override
	public Disease create(Disease d, String username) {
		User u = userRepository.getByUsername(username);
		if(u.getRole()!=UserRole.ADMIN)
			return null;
		
		Disease created = this.diseaseRepository.save(d);
		for(KieSession ks: CdssSpringAppApplication.kieSessions.values()) {
			ks.insert(created);
		}
		return created; 
		
	}




}
