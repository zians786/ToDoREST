package com.bridgeit.service;

import com.bridgeit.model.User;

public interface Service {
	

	String registrationValidate(User user);
		
	String verifyToken(String token);
	
	String loginValidate(User user);
	
	String forgetPassword(String email);
}
