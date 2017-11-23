package com.bridgeit.model;

import org.springframework.stereotype.Component;

@Component
public class Response {

	private String message;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	private String token;
}
