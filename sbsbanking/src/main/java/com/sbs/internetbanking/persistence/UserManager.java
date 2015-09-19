package com.sbs.internetbanking.persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.sbs.internetbanking.model.User;

public class UserManager {

	@Autowired
	SessionFactory sessionFactory;

	@Transactional
	public void saveUser(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(user);
	}

	@Transactional
	public void deleteUser(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(user);
	}

	@Transactional
	public void updateUser(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.update(user);
	}
}
