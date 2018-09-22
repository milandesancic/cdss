package rs.uns.ac.ftn.cdss.service;

import rs.uns.ac.ftn.cdss.dto.AuthenticationRequestDto;
import rs.uns.ac.ftn.cdss.model.User;

public interface UserService {

	public User getByUsername(String username);
	public Boolean login(AuthenticationRequestDto user);
	public Boolean logout(String username);
}
