package com.bridgeit.controller;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bridgeit.model.User;
import com.bridgeit.service.Service;
import com.bridgeit.validation.Validation;
@Controller
public class AppController {
	

	@Autowired
	Service service;

	@Autowired
	User user;
	
	@Autowired
	Validation validate;
		
	 @RequestMapping(value = {"/registration"}, method = RequestMethod.POST)
	 public ModelAndView registration(@ModelAttribute("register") User user ) {
			ModelAndView modelAndView = new ModelAndView();

			if(validate.userValidate(user)) {
				String message = service.registrationValidate(user);
				modelAndView.setViewName("index");
				modelAndView.addObject("message", message);
				return modelAndView;
			}else{
			modelAndView.setViewName("registration");
			modelAndView.addObject("message", "Please Enter Correct Values...");
				return modelAndView;
			}
		
}
	 
	 @RequestMapping(value = {"/login"}, method = RequestMethod.POST)
			public ModelAndView login(@ModelAttribute("loginForm") User user , HttpServletRequest request) {
		
				ModelAndView modelAndView = new ModelAndView();
				String name=service.loginValidate(user);
				if(name!=null) {
					
					
					HttpSession session=request.getSession();
					session.setAttribute("details", user.getUserName());
					modelAndView.setViewName("dashboard");
					return modelAndView;
					
				}else {
					modelAndView.setViewName("index");

					modelAndView.addObject("message", "Invalid Username or Password");
					return modelAndView;

				}
				

			
			}

		
	 @RequestMapping(value = {"/logout"}, method = RequestMethod.POST)
		public ModelAndView logout(HttpServletRequest request) {
			ModelAndView modelAndView = new ModelAndView();
			HttpSession session=request.getSession();
			session.invalidate();
			modelAndView.setViewName("index");

			modelAndView.addObject("message", "Logout Successfully...");
			return modelAndView;
			
		}
	 
	 }
