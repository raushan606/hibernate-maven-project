package com.tut;

import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {

	public static void main(String[] args) {
		
		// Get and load method
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		Session s = factory.openSession();
		
		// no need of transaction for get and load, 
		
		Student st = (Student)s.get(Student.class,13);
		
		System.out.println(st);
		
		try {
		Address ad = (Address)s.load(Address.class,200);
		System.out.println(ad.getCity());
		} catch(ObjectNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		factory.close();
	}
}
