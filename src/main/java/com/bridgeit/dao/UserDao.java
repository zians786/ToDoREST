package com.bridgeit.dao;

import com.bridgeit.model.User;

public interface UserDao {

	String loginValidate(User user);
	Boolean emailValidaton(String email);
	void registerUser(User user);
	int activateUser(String email);
	String getPassword(String email);
}
