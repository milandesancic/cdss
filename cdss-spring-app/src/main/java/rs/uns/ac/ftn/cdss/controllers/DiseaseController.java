package rs.uns.ac.ftn.cdss.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.uns.ac.ftn.cdss.model.Symptom;
import rs.uns.ac.ftn.cdss.security.TokenUtils;
import rs.uns.ac.ftn.cdss.service.DiseaseService;

@RestController
@RequestMapping("/api/diseases")
public class DiseaseController {
	
	@Autowired
	TokenUtils tokenUtils;
	
	@Autowired
	HttpServletRequest httpServetRequest;
	
	@Autowired
	DiseaseService diseaseService;
	
	
	@PostMapping("/get_by_symptoms/{id}")
	public ResponseEntity<?> getDisaseBySymptoms(@PathVariable Long id, @RequestBody ArrayList<Symptom> symptoms){
		String username = tokenUtils.getUsernameFromToken(httpServetRequest.getHeader("Bearer"));
		diseaseService.getDiseaseBySymptoms(id, symptoms, username);
		return null;
	}

}
