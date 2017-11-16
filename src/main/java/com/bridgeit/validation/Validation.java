package com.bridgeit.validation;

import org.springframework.stereotype.Component;

import com.bridgeit.model.User;

@Component
public class Validation {

	
	
public boolean userValidate(User user) {
	boolean status=true;
	String email="/^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+$/";
	String number="/^([9]{1})([234789]{1})([0-9]{8})$/";
	String username="/^[a-zA-Z]{4,15}/";
	String userNumber=Long.toString(user.getNumber());
	
	
//	if(!(user.getUserName()).matches(username)) {
//		System.out.println("user");
//		return false;
//	}
//	if(!email.matches(user.getEmail())) {
//		System.out.println("email");
//		return false;
//	}
//	if(!number.matches(userNumber)) {
//		System.out.println("number");
//		return false;
//	}
	return status;
}
	
}
