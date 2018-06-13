package rs.uns.ac.ftn.cdss.service.impl;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.uns.ac.ftn.cdss.service.TestService;

@Service
public class TestServiceImpl implements TestService{

	@Autowired
	KieContainer kieContainer;
	
	@Override
	public int test() {
		KieSession kieSession = kieContainer.newKieSession();
        int i = kieSession.fireAllRules();
        kieSession.dispose();
        return i;
	}

	
	
}
