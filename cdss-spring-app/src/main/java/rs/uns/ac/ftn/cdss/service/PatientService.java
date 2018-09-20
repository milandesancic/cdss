package rs.uns.ac.ftn.cdss.service;

import java.util.Set;

import rs.uns.ac.ftn.cdss.model.Patient;

public interface PatientService {

	
	public Set<Patient> getPatientsWithChronic(String username);
	
	public Set<Patient> getAddicts(String username);
	
	public Set<Patient> getPatientsWithWeakImmunity(String username);
}
