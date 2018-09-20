package rs.uns.ac.ftn.cdss.service;

import java.util.ArrayList;

import rs.uns.ac.ftn.cdss.model.Symptom;

public interface SymptomService {
	
	Symptom findById(Long id);
	
//	Collection<Symptom> getAll();
	
	ArrayList<Symptom> getSymptomsByDisease(Long disease, String username);

}
