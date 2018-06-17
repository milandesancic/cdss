package rs.uns.ac.ftn.cdss.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.uns.ac.ftn.cdss.dto.AuthenticationRequestDto;
import rs.uns.ac.ftn.cdss.dto.AuthenticationResponseDto;
import rs.uns.ac.ftn.cdss.model.User;
import rs.uns.ac.ftn.cdss.security.TokenUtils;
import rs.uns.ac.ftn.cdss.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserControler {

	@Autowired
	UserService userService;

	@Autowired
	TokenUtils tokeUtils;
	
	@Autowired
	HttpServletRequest httpServetRequest;

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody AuthenticationRequestDto authenticationRequest) {
		User u = userService.getByUsername(authenticationRequest.getUsername());
		if (u == null) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			String token = tokeUtils.generateToken(u);
			System.out.println(token);
			AuthenticationResponseDto respnse = new AuthenticationResponseDto(token, u.getId(), u.getUsername(),
					u.getRole());
			/**
			 * POTREBNO Dodavat kie sesije prilikom logovanja
			 * **/
			return new ResponseEntity<>(respnse, HttpStatus.OK);

		}
	}
	
	@GetMapping
	public void printUsername() {
		String username = this.tokeUtils.getUsernameFromToken(this.httpServetRequest.getHeader("Bearer"));
		System.out.println(username);
	}
}
