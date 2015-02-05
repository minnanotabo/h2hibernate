package com.ms;
 
import com.ms.h2hibernate.ShortURL;
import com.ms.h2hibernate.service.ShortURLService;

public class ShortURLTest {
	public static void main(String[] args) {
		System.out.println("Maven + Hibernate + Oracle");

		ShortURLService service = new ShortURLService();
		String shortURL = null;
		
		String[] ourls = { "long1", "long2", "long3"};
		for (String ourl : ourls) {
			shortURL = service.addShortURL(ourl, ourl + "abc@gmail.com");
			System.out.println("shortURL for " + ourl + " is: " + shortURL);
		}

		String myShort = service.getOriginalURL(shortURL);
		System.out.println("originalURL: " + myShort);
		
		ShortURL sURL = service.getShortURLObj(shortURL);
		System.out.println("shortURLObj: " + sURL);
		
		service.listShortURL();
		
	}
}