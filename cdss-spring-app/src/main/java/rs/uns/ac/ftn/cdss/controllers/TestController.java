package rs.uns.ac.ftn.cdss.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.uns.ac.ftn.cdss.service.TestService;

@RestController
@RequestMapping("api/test")
public class TestController {
	
	@Autowired
	TestService testService;
	
	@GetMapping()
	public int testController() {
		return testService.test();
	}

}
