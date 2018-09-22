package rs.uns.ac.ftn.cdss.service;

import java.util.ArrayList;
import java.util.Collection;

import rs.uns.ac.ftn.cdss.model.Symptom;

public interface SymptomService {
	
	Symptom findById(Long id);
	
	Collection<Symptom> getAllSymptoms();
	
	ArrayList<Symptom> getSymptomsByDisease(Long disease, String username);

}
