package rs.uns.ac.ftn.cdss.dto;

import rs.uns.ac.ftn.cdss.model.UserRole;

public class AuthenticationResponseDto {
	
	private String token;
	private Long id;
	private String username;
	private UserRole role;
	
	public AuthenticationResponseDto() {
	}
	
	public AuthenticationResponseDto(String token, Long id, String username, UserRole role) {
		super();
		this.token = token;
		this.id = id;
		this.username = username;
		this.role = role;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}
	
}
