package com.smart.auth;

import java.util.Set;
import java.util.stream.Collectors;

import com.smart.entity.Userss;

public class LoginResponse {
	
	private String token;
	private Userss user;
//	private String username;
//	private String email;
//	private boolean otpVerified;
//	private Long id;
//	private Set<String>roles;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public LoginResponse() {
	}

	public LoginResponse(String jwtToken) {
		this.token = jwtToken;
	}

	public LoginResponse(String jwtToken, Userss user) {
		this.token = jwtToken;
		this.user = user;
	}

	public Userss getUser() {
		return user;
	}

	public void setUser(Userss user) {
		this.user = user;
	}

//	public String getUsername() {
//		return username;
//	}
//
//	public void setUsername(String username) {
//		this.username = username;
//	}
//
//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
//	public boolean isOtpVerified() {
//		return otpVerified;
//	}
//
//	public void setOtpVerified(boolean otpVerified) {
//		this.otpVerified = otpVerified;
//	}
//
//	public Long getId() {
//		return id;
//	}

//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public Set<String> getRoles() {
//		return roles;
//	}
//
//	public void setRoles(Set<String> roles) {
//		this.roles = roles;
//	}
	
	

}
