package rs.uns.ac.ftn.cdss.service.impl;

import org.springframework.stereotype.Service;

import rs.uns.ac.ftn.cdss.service.TestService;

@Service
public class TestServiceImpl implements TestService{

	@Override
	public int test() {
		return 8;
	}

	
	
}
