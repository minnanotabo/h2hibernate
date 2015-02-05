package com.ms.h2hibernate.service;

import org.hibernate.Session;

import com.ms.h2hibernate.DBUser;
import com.ms.util.HibernateUtil;

public class UserService {

	public int addUser(DBUser user){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		return 0;
	}
}
