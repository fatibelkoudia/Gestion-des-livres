package com.tima.tp1.dao;


import org.hibernate.Session;
import org.hibernate.Transaction;

import com.tima.tp1.model.User;
import com.tima.tp1.utils.HibernateUtil;

import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;

public class UserDao {
	
	public User checkLogin(String login, String password) {
		Transaction transaction = null;
		User user = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			Query query=session.createQuery("from User where login=:login and password=:password", User.class);
		    query.setParameter("login", login);
	        query.setParameter("password", password);
	        try {
	        	user=(User) query.getSingleResult();
	        } catch (NoResultException ex) {
	        	user = null;
	        }
			transaction.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			if (transaction != null) {
				transaction.rollback();
			}
		}
		return user;
	}

}
