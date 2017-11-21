package com.bridgeit.controller;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.bridgeit.model.User;
import com.bridgeit.service.Service;
import com.bridgeit.validation.Validation;

@RestController
public class AppController {
	

	@Autowired
	Service service;

	@Autowired
	Validation validate;
		
	 @RequestMapping(value = {"/"}, method = RequestMethod.GET)
	 public String welcome() {
		 return "Welcome";
	 }
	
	 @RequestMapping(value = {"/register"}, method = RequestMethod.POST)
	 public ResponseEntity<String> registration(@RequestBody User user) {
			

			if(validate.userValidate(user)) {
				String message = service.registrationValidate(user);
				return new ResponseEntity<String>(message, HttpStatus.OK);
			}else{
			String message= "Please Enter Correct Values...";
				return new ResponseEntity<String>(message, HttpStatus.CONFLICT);
			}
		
}
	 
	 @RequestMapping(value = {"/login"}, method = RequestMethod.POST)
			public ResponseEntity<String> login(@RequestBody User user , HttpServletRequest request) {
		
				String name=service.loginValidate(user);
				if(name!=null) {
					
					
					HttpSession session=request.getSession();
					String message= "Welcome "+user.getUserName();
					
					return new ResponseEntity<String>(message, HttpStatus.OK);
					
				}else {
					String message= "Invalid Username or Password";
					return new ResponseEntity<String>(message, HttpStatus.CONFLICT);

				}
				

			
			}

		
	 @RequestMapping(value = {"/logout"}, method = RequestMethod.POST)
		public ResponseEntity<String> logout(HttpServletRequest request) {
		 String message="No Active Session";
			HttpSession session=request.getSession();
			if(session.isNew()) {
				return new ResponseEntity<String>(message, HttpStatus.CONFLICT);
			}
			session.invalidate();
		
			message="Logout Successfully...";
			return new ResponseEntity<String>(message, HttpStatus.OK);
			
		}
	 
	 }
