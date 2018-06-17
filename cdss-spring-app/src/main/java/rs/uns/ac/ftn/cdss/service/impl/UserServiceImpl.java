package rs.uns.ac.ftn.cdss.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.uns.ac.ftn.cdss.model.User;
import rs.uns.ac.ftn.cdss.repository.UserRepository;
import rs.uns.ac.ftn.cdss.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public User getByUsername(String username) {
		return this.userRepository.getByUsername(username);
	}

}
