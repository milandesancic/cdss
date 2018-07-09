package rs.uns.ac.ftn.cdss.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;

import rs.uns.ac.ftn.cdss.CdssSpringAppApplication;
import rs.uns.ac.ftn.cdss.dto.DiseaseDto;
import rs.uns.ac.ftn.cdss.dto.SymptomDto;
import rs.uns.ac.ftn.cdss.dto.Symptoms;
import rs.uns.ac.ftn.cdss.service.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService{

	@Override
	public void calculateDisease(Symptoms symptoms,String username) {
		
		KieSession kie =  CdssSpringAppApplication.kieSessions.get(username);
		
		List<SymptomDto> symptomsList = new ArrayList<>();
		SymptomDto s = new SymptomDto("Curenje iz nosa", null);
		symptomsList.add(s);
		s = new SymptomDto("Bol u grlu",null);
		symptomsList.add(s);
		s = new SymptomDto("Glavobolja",null);
		symptomsList.add(s);
		s = new SymptomDto("Kijanje",null);
		symptomsList.add(s);
		s = new SymptomDto("Kašalj",null);
		symptomsList.add(s);
		DiseaseDto d = new DiseaseDto("Prehlada", symptomsList);
		
		kie.insert(d);
		kie.insert(symptoms);
		kie.fireAllRules();
	}

}
