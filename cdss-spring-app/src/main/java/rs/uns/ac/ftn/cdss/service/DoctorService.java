package rs.uns.ac.ftn.cdss.service;

import rs.uns.ac.ftn.cdss.dto.AllergiesDto;
import rs.uns.ac.ftn.cdss.dto.RecordDto;

public interface DoctorService {
	
	public AllergiesDto makeDiagnose(Long id, RecordDto newRecord, String username);

}
