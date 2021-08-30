package com.tut;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws IOException {
		System.out.println("Hello World!");

		SessionFactory factory = new Configuration().configure().buildSessionFactory();

		// creating obj of Student
		Student st = new Student("Raushan", "Ratanpur");
		Student st1 = new Student("Raushan Kumar", "Ratanpur,Kanap");

		System.out.println(st);

		Address ad = new Address();
		ad.setStreet("street1");
		ad.setCity("Delhi");
		ad.setOpen(true);
		ad.setAddedDate(new Date());
		ad.setX(23.3);
		
		// Reading Image
		FileInputStream fis = new FileInputStream("src/main/java/tcsss.png");
		byte[] data = new byte[fis.available()];
		fis.read(data);
		ad.setImage(data);
		

		Session s = factory.openSession();

		org.hibernate.Transaction tx = s.beginTransaction();

		s.save(st);
		s.save(st1);
		s.save(ad);

		tx.commit();

		s.close();

	}
}
