package com.ms.h2hibernate.service;

import java.util.Date;

import org.apache.commons.lang3.RandomStringUtils;
import org.hibernate.Session;

import com.ms.h2hibernate.ShortURL;
import com.ms.util.HibernateUtil;

public class ShortURLService {

	public String addShortURL (String originalURL, String loginId) {
		ShortURL shortURL = new ShortURL();
		 
		//shortURL.setId(100);
		shortURL.setOriginalURL(originalURL);
		shortURL.setCreateDate(new Date());
		shortURL.setUpdateDate(new Date());
		String sURL = RandomStringUtils.randomAlphanumeric(6);
		shortURL.setShortURL(sURL);
		shortURL.setLoginId(loginId);

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(shortURL);
		session.getTransaction().commit();
		return sURL;
	}
	
	public String getOriginalURL (String shortURLText) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		ShortURL shortURL = (ShortURL) session.get(ShortURL.class, shortURLText);
        session.close();
        return shortURL.getOriginalURL();
	}
	
	public ShortURL getShortURLObj (String shortURLText) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		ShortURL shortURL = (ShortURL) session.get(ShortURL.class, shortURLText);
        session.close();
        return shortURL;
	}

}
