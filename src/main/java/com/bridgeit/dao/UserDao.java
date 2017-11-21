package com.bridgeit.dao;

import com.bridgeit.model.User;

public interface UserDao {

	String loginValidate(User user);
	String emailValidaton(User user);
}
