package rs.uns.ac.ftn.cdss.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.QueryResults;
import org.kie.api.runtime.rule.QueryResultsRow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.uns.ac.ftn.cdss.CdssSpringAppApplication;
import rs.uns.ac.ftn.cdss.model.Disease;
import rs.uns.ac.ftn.cdss.model.Medicine;
import rs.uns.ac.ftn.cdss.model.MedicineType;
import rs.uns.ac.ftn.cdss.model.Patient;
import rs.uns.ac.ftn.cdss.model.util.DateChecker;
import rs.uns.ac.ftn.cdss.repository.MedicineRepository;
import rs.uns.ac.ftn.cdss.repository.PatientRepository;
import rs.uns.ac.ftn.cdss.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	PatientRepository patientRepository;

	@Autowired
	MedicineRepository medicineRepository;

	@SuppressWarnings("unchecked")
	@Override
	public Set<Patient> getPatientsWithChronic(String username) {
		KieSession kieSession = CdssSpringAppApplication.kieSessions.get(username);

		if (kieSession == null) {
			return null;
		}

		List<Patient> patients = patientRepository.findAll();
		for (Patient p : patients) {
			kieSession.insert(p);
		}

		kieSession.insert(new DateChecker());

		QueryResults results = kieSession
				.getQueryResults("Pacijent sa hronicnom bolescu koja nije prehlada ili groznica", "list");
		System.out.println(results.size());

		ArrayList<Patient> foundPatients = new ArrayList<>();
		ArrayList<Disease> foundDiseases = new ArrayList<>();
		for (QueryResultsRow row : results) {

			Patient p = (Patient) row.get("p");
			Disease d = (Disease) row.get("d");

			Collection<Long> longs = (Collection<Long>) row.get("list");
			System.err.println(longs.size());
			foundPatients.add(p);
			foundDiseases.add(d);
		}
		Set<Patient> uniquePatients = new HashSet<Patient>(foundPatients);
		release(kieSession);
		return uniquePatients;

	}

	@Override
	public Set<Patient> getAddicts(String username) {
		KieSession kieSession = CdssSpringAppApplication.kieSessions.get(username);

		if (kieSession == null) {
			return null;
		}
		List<Patient> patients = patientRepository.findAll();
		for (Patient p : patients) {
			kieSession.insert(p);
		}
		Medicine m = new Medicine();
		m.setMedicineType(MedicineType.ANALGETIC);
		kieSession.insert(m);
		kieSession.insert(new DateChecker());

		QueryResults results = kieSession.getQueryResults("Zavisnik");
		System.out.println(results.size());

		ArrayList<Patient> foundPatients = new ArrayList<>();
		for (QueryResultsRow row : results) {
			Patient p = (Patient) row.get("p");
			foundPatients.add(p);
		}
		release(kieSession);
		Set<Patient> uniquePatients = new HashSet<Patient>(foundPatients);
		return uniquePatients;

	}

	@SuppressWarnings("unchecked")
	@Override
	public Set<Patient> getPatientsWithWeakImmunity(String username) {
		KieSession kieSession = CdssSpringAppApplication.kieSessions.get(username);

		if (kieSession == null) {
			return null;
		}
		
		List<Patient> patients=patientRepository.findAll();
		for(Patient p:patients) {
			kieSession.insert(p);
		}
		kieSession.insert(new DateChecker());

		QueryResults results = kieSession.getQueryResults( "Slab imunitet" );
		System.out.println(results.size());

		ArrayList<Patient> foundPatients=new ArrayList<>();
		for ( QueryResultsRow row : results ) {
		 	Patient p = ( Patient ) row.get( "p" );
		 	Collection<Medicine> med=(Collection<Medicine>) row.get("medicinesList");
		 	System.err.println("medlist "+med.size());
		 	Collection<Medicine> ant=(Collection<Medicine>) row.get("antibioticsList");
		 	System.err.println("antlist "+ant.size());
		 	
			foundPatients.add(p);
		}
		release(kieSession);
		Set<Patient> uniquePatients = new HashSet<Patient>(foundPatients);
		return uniquePatients;
	}

	public void release(KieSession kieSession) {
		for (Object object : kieSession.getObjects()) {
			if (!object.getClass().equals(Disease.class))
				kieSession.delete(kieSession.getFactHandle(object));
		}
	}

}
