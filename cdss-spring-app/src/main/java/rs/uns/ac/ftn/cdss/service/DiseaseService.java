package rs.uns.ac.ftn.cdss.service;

import java.util.ArrayList;
import java.util.List;

import rs.uns.ac.ftn.cdss.model.Disease;
import rs.uns.ac.ftn.cdss.model.Record;
import rs.uns.ac.ftn.cdss.model.Symptom;

public interface DiseaseService {

	public Record getDiseaseBySymptoms(Long id, ArrayList<Symptom> symptoms, String username);

	public ArrayList<Disease> getDiseaseFromQuery(ArrayList<Symptom> symptoms, String username);
	
	public List<Disease> getAll();

}
