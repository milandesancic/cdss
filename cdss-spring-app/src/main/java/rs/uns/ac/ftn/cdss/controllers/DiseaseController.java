package rs.uns.ac.ftn.cdss.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.uns.ac.ftn.cdss.model.Disease;
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
	
	@GetMapping
	public ResponseEntity<?> getAll(){
		return new ResponseEntity<>(this.diseaseService.getAll(),HttpStatus.OK);
	}
	
	@PostMapping("/get_by_symptoms/{id}")
	public ResponseEntity<?> getDisaseBySymptoms(@PathVariable Long id, @RequestBody ArrayList<Symptom> symptoms){
		String username = tokenUtils.getUsernameFromToken(httpServetRequest.getHeader("Bearer"));
		Disease d = diseaseService.getDiseaseBySymptoms(id, symptoms, username);
		if(d==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<>(d,HttpStatus.OK);
		}
	}
	
	@PostMapping("/get_by_symptoms")
	public ResponseEntity<?> getDisaseByQuerySymptoms(@RequestBody ArrayList<Symptom> symptoms){
		String username = tokenUtils.getUsernameFromToken(httpServetRequest.getHeader("Bearer"));
		ArrayList<Disease> diseases = diseaseService.getDiseaseFromQuery(symptoms, username);
		if(diseases==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(diseases,HttpStatus.OK);
	}
	

}
