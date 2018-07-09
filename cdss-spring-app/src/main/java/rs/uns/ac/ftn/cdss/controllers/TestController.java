package rs.uns.ac.ftn.cdss.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.uns.ac.ftn.cdss.CdssSpringAppApplication;
import rs.uns.ac.ftn.cdss.service.TestService;

@RestController
@RequestMapping("api/test")
public class TestController {
	
	@Autowired
	TestService testService;
	
	@GetMapping()
	public int testController() {
		System.out.println(CdssSpringAppApplication.kieSessions.keySet());
		System.out.println(CdssSpringAppApplication.kieSessions.values());
		//System.out.println(CdssSpringAppApplication.kieSessions.get("doktor1")==CdssSpringAppApplication.kieSessions.get("doktor2"));
		return CdssSpringAppApplication.kieSessions.size();
	}
	
	@GetMapping("/rules")
	public void  testRules() {
		CdssSpringAppApplication.kieSessions.get("doktor1").fireAllRules();
	}

}
