package com.smart.auth;

public class LoginResponse {
	
	private String token;

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

}
