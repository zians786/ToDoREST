package com.bridgeit.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bridgeit.model.User;

@Repository("userDao")
public class UserDaoImp implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public String loginValidate(User user) {
		Query query = getSession().createQuery("select email from User where userName='" + user.getUserName()
				+ "' and password='" + user.getPassword() + "'");
		String result = (String) query.uniqueResult();
		String name = null;
		if (result != null) {
			name = "true";
		}
		return name;
	}

	@Override
	public Boolean emailValidaton(String email) {

		Query query = getSession().createQuery("select userName from User where email='" + email + "'");
		String result = (String) query.uniqueResult();
		Boolean status;

		if (result != null) {
			status = true;
		} else {
			status = false;
		}
		return status;

	}

	@Override
	public int activateUser(String email) {
		Query query=getSession().createQuery("update User set active=:a where email=:e");
		query.setParameter("a", true);
		query.setParameter("e", email);
		int result=query.executeUpdate();
		return result;
	}

	@Override
	public void registerUser(User user) {
		user.setActive(false);
		getSession().save(user);
	}

	@Override
	public String getPassword(String email) {

		Query query = getSession().createQuery("select password from User where email='" + email + "'");
		String result = (String) query.uniqueResult();
		return result;
	}


	
}
