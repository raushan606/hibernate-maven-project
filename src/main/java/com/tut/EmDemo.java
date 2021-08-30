package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure().buildSessionFactory();

		Student st = new Student();
		st.setName("ankit");
		st.setCity("Delhi");

		Certificate c = new Certificate();
		c.setCourse("android");
		c.setDuration("2 months");

		st.setCerti(c);

		Student st1 = new Student();
		st1.setName("Ravi");
		st1.setCity("Delhi Old");

		Certificate c1 = new Certificate();
		c1.setCourse("Hibernate");
		c1.setDuration("2.5 months");

		st1.setCerti(c1);

		Session s = factory.openSession();

		Transaction tx = s.beginTransaction();

		s.save(st);
		s.save(st1);

		tx.commit();

		s.close();

		factory.close();
	}
}
