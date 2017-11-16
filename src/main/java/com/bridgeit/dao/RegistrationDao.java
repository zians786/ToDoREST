package com.bridgeit.dao;

import org.springframework.stereotype.Component;

import com.bridgeit.model.User;


public interface RegistrationDao {
	String emailValidaton(User user);
}
