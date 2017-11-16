package com.bridgeit.service;

import com.bridgeit.model.User;

public interface Service {
	

	String registrationValidate(User user);

	String loginValidate(User user);
}
