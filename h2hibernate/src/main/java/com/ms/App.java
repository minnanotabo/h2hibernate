package com.ms;
 
import java.util.Date;

import org.hibernate.Session;

import com.ms.util.HibernateUtil;
import com.ms.h2hibernate.DBUser;
import com.ms.h2hibernate.Product;
import com.ms.h2hibernate.service.UserService;
 
public class App {
	public static void main(String[] args) {
		System.out.println("Maven + Hibernate + Oracle");
		Session session = HibernateUtil.getSessionFactory().openSession();
 
		session.beginTransaction();
		DBUser user = new DBUser();
 
		user.setUserId(100);
		user.setUsername("superman");
		user.setCreatedBy("system");
		user.setCreatedDate(new Date());
		user.setNickname("nick");

		Product p = new Product();
		p.setPID("VVAB12345678");
		p.setType("audio");
		p.setTitle("my first song");
		p.setArtist("my little airport");
		p.setDuration(50);


		session.save(user);
		session.save(p);
		session.getTransaction().commit();
		
		session.beginTransaction();
		DBUser olduser = (DBUser)session.get(DBUser.class, 100);
		Product p1 = (Product)session.get(Product.class, "VVAB12345678");
		System.out.println("retrieved user: " + olduser);
		System.out.println("retrieved product: " + p1);
		user.setUsername("spiderman");
		user.setNickname("spidernick");
		session.save(user);
		session.getTransaction().commit();
		DBUser yetanotherolduser = (DBUser)session.get(DBUser.class, 100);
		System.out.println("retrieved user: " + yetanotherolduser);
		
		user = new DBUser();
		 
		user.setUserId(101);
		user.setUsername("addbyservice");
		user.setCreatedBy("testprogram");
		user.setCreatedDate(new Date());
		user.setNickname("service");

		UserService userService = new UserService();
		userService.addUser(user);
	}
}