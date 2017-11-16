
package com.bridgeit.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.bridgeit.model.User;

public class RegistrationDaoImp implements RegistrationDao {


	 @Autowired
	 private SessionFactory sessionFactory;
	 
	protected Session getSession(){
	        return sessionFactory.getCurrentSession();
	    }
	
	@Autowired
	User user;

	

	public String emailValidaton(final User user) {
		
		
		
		Query query=getSession().createQuery("select userName from registration where email='" + user.getEmail() + "'");
		String result=(String) query.uniqueResult();
		String name;
	
		if (result==null) {
								name="User Already Exist with this Email...";
							}
							else {
								Query query2=getSession().createQuery("insert into registration values('"+user.getUserName()+"','"+user.getEmail()+"','"+user.getPassword()+"','"+user.getNumber()+"'");
								int queryResult=query2.executeUpdate();
								if(queryResult>0) {
									name="Registration Successfull, Please Login...";	
								}
								else {
									name="Registration UnSuccessfull, Please Register Again...";
							   	}
							}
						
						return name;
					}


}
