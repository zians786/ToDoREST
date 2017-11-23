
package com.bridgeit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.bridgeit.dao.UserDao;
import com.bridgeit.model.User;
import com.bridgeit.utility.Email;
import com.bridgeit.utility.JWT;
import com.bridgeit.validation.Encryption;

@Component
@Transactional
public class ServiceImp implements Service {

	@Autowired
	UserDao userDao;

	@Autowired
	JWT jwt;

	@Autowired
	Encryption encrypt;

	@Autowired
	Email email;

	public String registrationValidate(User user) {
		user.setPassword(encrypt.encryptPassword(user.getPassword()));

		if (userDao.emailValidaton(user.getEmail())) {
			return "User Already Exist with this Email...";
		} else {
			userDao.registerUser(user);
			String id=Integer.toString(user.getUserId());
			String jwToken = jwt.jwtGenerator(id);

			email.registrationEmail(user.getEmail(), jwToken);

			return "Registration Successfull, Please check confirmation mail to Activate your Account";

		}

	}

	public String loginValidate(User user) {
		String jwToken;
		user.setPassword(encrypt.encryptPassword(user.getPassword()));
		if(userDao.loginValidate(user)) {
			int id=userDao.getUserId(user.getUserName());
			String uid=Integer.toString(id);
			jwToken = jwt.jwtGenerator(uid);
		}else {
			jwToken =null;
		}

		return jwToken;

	}

	public String verifyToken(String token) {
		String uid = jwt.jwtVerify(token);
		int userId=Integer.parseInt(uid);
		
		String result = null;
		
			if (userDao.activateUser(userId) > 0) {
				result = "Your Account has been Activated...";
			} else {
				result = "Invalid Token or User may not Registered with us..";
			}
			return result;
		} 
		
	

	public String forgetPassword(String userEmail) {
		String result = null;
		if (userDao.emailValidaton(userEmail)) {
		String password=userDao.getPassword(userEmail);
		email.forgetEmail(userEmail,password);
		result = "Password has been Sent to your email.";
		} else {
			result = "This email is not Register with us.";
		}
		return result;
	}

}
