package rs.uns.ac.ftn.cdss.controllers;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.uns.ac.ftn.cdss.model.Patient;
import rs.uns.ac.ftn.cdss.security.TokenUtils;
import rs.uns.ac.ftn.cdss.service.PatientService;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

	@Autowired
	TokenUtils tokenUtils;

	@Autowired
	HttpServletRequest httpServetRequest;
	
	@Autowired
	PatientService patientService;

	@GetMapping("/with_chronic")
	public ResponseEntity<?> getPatientWithChronic() {
		String username = tokenUtils.getUsernameFromToken(httpServetRequest.getHeader("Bearer"));
		Set<Patient>response = patientService.getPatientsWithChronic(username);
		if(response==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@GetMapping("/addicts")
	public ResponseEntity<?> getPatientsAddicts(){
		String username = tokenUtils.getUsernameFromToken(httpServetRequest.getHeader("Bearer"));
		Set<Patient>response = patientService.getAddicts(username);
		if(response==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@GetMapping("/weak_immunity")
	public ResponseEntity<?> getPatientsWithWeakImmunity(){
		String username = tokenUtils.getUsernameFromToken(httpServetRequest.getHeader("Bearer"));
		Set<Patient>response = patientService.getPatientsWithWeakImmunity(username);
		if(response==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
}
