package rs.uns.ac.ftn.cdss.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.uns.ac.ftn.cdss.dto.AllergiesDto;
import rs.uns.ac.ftn.cdss.dto.RecordDto;
import rs.uns.ac.ftn.cdss.security.TokenUtils;
import rs.uns.ac.ftn.cdss.service.DoctorService;

@RestController
@RequestMapping("api/doctor")
public class DoctorController {
	
	@Autowired
	DoctorService doctorService;

	@Autowired
	HttpServletRequest httpServetRequest;
	
	@Autowired
	TokenUtils tokenUtils;
	
	@PostMapping("/patient/{id}")
	public ResponseEntity<?> makeDiagnose(@PathVariable Long id,@RequestBody RecordDto newRecord){
		String username = tokenUtils.getUsernameFromToken(httpServetRequest.getHeader("Bearer"));
		AllergiesDto response =  doctorService.makeDiagnose(id, newRecord, username);
		if(response==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<>(response,HttpStatus.OK);
		}
	}
}

