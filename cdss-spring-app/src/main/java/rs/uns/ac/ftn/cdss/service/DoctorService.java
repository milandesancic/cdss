package rs.uns.ac.ftn.cdss.service;

import rs.uns.ac.ftn.cdss.dto.Symptoms;

public interface DoctorService {
	
	public void calculateDisease(Symptoms symptoms,String username);

}
