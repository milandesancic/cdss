package rs.uns.ac.ftn.cdss.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.uns.ac.ftn.cdss.security.TokenUtils;
import rs.uns.ac.ftn.cdss.service.SymptomService;
import rs.uns.ac.ftn.cdss.service.UserService;

@RestController
@RequestMapping(value="/api/symptoms")
public class SymptomController {

	@Autowired
	SymptomService symptomService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	TokenUtils tokenUtils;
	
	@Autowired
	HttpServletRequest httpServetRequest;
	
	@GetMapping
	public ResponseEntity<?>getAllSymptoms(){
		return new ResponseEntity<>(symptomService.getAllSymptoms(),HttpStatus.OK);
	}
	
	@GetMapping(value="/get_by_disease/{id}")
	public ResponseEntity<?> getSymptoms(@PathVariable Long id){
		String username = tokenUtils.getUsernameFromToken(httpServetRequest.getHeader("Bearer"));
		System.out.println(username);
		return new ResponseEntity<>(symptomService.getSymptomsByDisease(id, username),HttpStatus.OK);
	}
	
}
