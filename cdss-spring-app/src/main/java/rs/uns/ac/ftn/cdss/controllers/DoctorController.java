package rs.uns.ac.ftn.cdss.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.uns.ac.ftn.cdss.dto.Symptoms;
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
	
	@PostMapping("/disease")
	public void getDisease(@RequestBody Symptoms symptoms) {
		String username = tokenUtils.getUsernameFromToken(httpServetRequest.getHeader("Bearer"));
		doctorService.calculateDisease(symptoms, username);
	}
}

