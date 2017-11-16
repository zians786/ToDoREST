
package com.bridgeit.dao;

import java.sql.ResultSet;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.bridgeit.model.User;

public class LoginDaoImp implements LoginDao {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	User user;
	
	public String loginValidate() {
		

		return jdbcTemplate.query("select * from registration where username='" +user.getUserName() + "' and password='"+user.getPassword()+"'",
				new ResultSetExtractor<String>() {
					public String extractData(ResultSet result) {
						String name=null;
						try {
							if (result.next()) {
								name="true";
							}
						} catch (SQLException e) {
							e.printStackTrace();
						}
						return name;
					}
				});
		
	}
	
	
	
}
