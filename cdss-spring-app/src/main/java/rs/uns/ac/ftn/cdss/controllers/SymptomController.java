package rs.uns.ac.ftn.cdss.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.uns.ac.ftn.cdss.model.Disease;
import rs.uns.ac.ftn.cdss.security.TokenUtils;
import rs.uns.ac.ftn.cdss.service.SymptomService;
import rs.uns.ac.ftn.cdss.service.UserService;

@RestController
@RequestMapping(value="/api/symptom")
public class SymptomController {

	@Autowired
	SymptomService symptomService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	TokenUtils tokenUtils;
	
	@Autowired
	HttpServletRequest httpServetRequest;
	
	@PostMapping(value="/get_by_disease")
	public ResponseEntity<?> getSymptoms(@RequestBody Disease d){
		String username = tokenUtils.getUsernameFromToken(httpServetRequest.getHeader("Bearer"));
		System.out.println(username);
		return new ResponseEntity<>(symptomService.getSymptomsByDisease(d, username),HttpStatus.OK);
	}
	
}
