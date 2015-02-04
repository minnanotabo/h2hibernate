package com.ms;
 
import java.util.Date;
import org.hibernate.Session;
import com.ms.util.HibernateUtil;
import com.ms.h2hibernate.DBUser;
 
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
 
		session.save(user);
		session.getTransaction().commit();

		session.beginTransaction();
		DBUser olduser = (DBUser)session.get(DBUser.class, 100);
		System.out.println("retrieved user: " + olduser.getUsername() + " " + olduser.getCreatedDate());
		user.setUsername("spiderman");
		session.save(user);
		session.getTransaction().commit();
		DBUser yetanotherolduser = (DBUser)session.get(DBUser.class, 100);
		System.out.println("retrieved user: " + yetanotherolduser.getUsername() +
				" " + yetanotherolduser.getCreatedDate());
	}
}