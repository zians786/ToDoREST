
package com.bridgeit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.bridgeit.dao.UserDao;
import com.bridgeit.model.User;
import com.bridgeit.validation.Encryption;

@Component
@Transactional
public class ServiceImp implements Service{

	@Autowired
	UserDao userDao;
	
	@Autowired
	Encryption encrypt;
	
	
	public String registrationValidate(User user) {
		user.setPassword(encrypt.encryptPassword(user.getPassword()));
		String result=userDao.emailValidaton(user);
		return result;
		}
	
	public String loginValidate(User user) {
		user.setPassword(encrypt.encryptPassword(user.getPassword()));
		String result=userDao.loginValidate(user);
		return result;
		
	}
	
}
