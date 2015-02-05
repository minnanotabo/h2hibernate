package com.ms;
 
import com.ms.h2hibernate.ShortURL;
import com.ms.h2hibernate.service.ShortURLService;

public class ShortURLTest {
	public static void main(String[] args) {
		System.out.println("Maven + Hibernate + Oracle");
		
		ShortURLService service = new ShortURLService();
		String shortURL = service.addShortURL("longlong123", "abc@gmail.com");
		System.out.println("shortURL: " + shortURL);
		
		String myShort = service.getOriginalURL(shortURL);
		System.out.println("originalURL: " + myShort);
		
		ShortURL sURL = service.getShortURLObj(shortURL);
		System.out.println("shortURLObj: " + sURL);
		
	}
}