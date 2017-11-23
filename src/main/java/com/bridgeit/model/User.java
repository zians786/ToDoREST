package com.bridgeit.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;


@Entity
@Table(name="Registration")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	
	private String email;
	
	private long number;
	private String userName,password;
	Boolean active;
	

	
	public int getUserId() {
		return userId;
	}
	

	public void setUserId(int userId) {
		this.userId = userId;
	}


	
	
	
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}

	
	public long getNumber() {
		return number;
	}
	public void setNumber(long number) {
		this.number = number;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
