package rs.uns.ac.ftn.cdss.service;

import java.util.ArrayList;
import java.util.Collection;

import rs.uns.ac.ftn.cdss.model.Disease;
import rs.uns.ac.ftn.cdss.model.Symptom;

public interface SymptomService {
	
	Symptom findById(Long id);
	
//	Collection<Symptom> getAll();
	
	ArrayList<Symptom> getSymptomsByDisease(Disease disease, String username);

}
