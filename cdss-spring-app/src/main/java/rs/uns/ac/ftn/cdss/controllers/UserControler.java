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

import rs.uns.ac.ftn.cdss.CdssSpringAppApplication;
import rs.uns.ac.ftn.cdss.dto.AuthenticationRequestDto;
import rs.uns.ac.ftn.cdss.dto.AuthenticationResponseDto;
import rs.uns.ac.ftn.cdss.dto.DoctorDto;
import rs.uns.ac.ftn.cdss.model.User;
import rs.uns.ac.ftn.cdss.security.TokenUtils;
import rs.uns.ac.ftn.cdss.service.AdminService;
import rs.uns.ac.ftn.cdss.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserControler {

	@Autowired
	UserService userService;

	@Autowired
	AdminService adminService;

	@Autowired
	TokenUtils tokeUtils;

	@Autowired
	HttpServletRequest httpServetRequest;

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody AuthenticationRequestDto authenticationRequest) {

		Boolean response = userService.login(authenticationRequest);
		if (!response) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		
		User u = userService.getByUsername(authenticationRequest.getUsername());
		String token = tokeUtils.generateToken(u);
		System.out.println(token);
		AuthenticationResponseDto respnse = new AuthenticationResponseDto(token, u.getId(), u.getUsername(),
				u.getRole());
		System.out.println("Broj ulogovanih korniska:" + CdssSpringAppApplication.kieSessions.size());
		
		return new ResponseEntity<>(respnse, HttpStatus.OK);

	}

	@GetMapping("/logout")
	public Boolean logout(){
		String username = this.tokeUtils.getUsernameFromToken(this.httpServetRequest.getHeader("Bearer"));
		return this.userService.logout(username);
	}

	@GetMapping
	public void printUsername() {
		String username = this.tokeUtils.getUsernameFromToken(this.httpServetRequest.getHeader("Bearer"));
		System.out.println(username);
	}

	@PostMapping
	public ResponseEntity<?> addNewDoctor(@RequestBody DoctorDto newDoctor) {
		String username = this.tokeUtils.getUsernameFromToken(this.httpServetRequest.getHeader("Bearer"));
		if (adminService.addDoctor(newDoctor, username)) {
			return new ResponseEntity<>(true, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
