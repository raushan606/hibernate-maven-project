package com.map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure().buildSessionFactory();

		// Create question
		Question q1 = new Question();
		q1.setQid(1);
		q1.setQuestion("What is Java?");

		// creating answer;
		Answer ans = new Answer();
		ans.setAid(11);
		ans.setAnswer("Prog. language");
		ans.setQ(q1);
		q1.setAnswer(ans);
		
		
		// Create question
		Question q2 = new Question();
		q2.setQid(2);
		q2.setQuestion("What is python?");

		// creating answer;
		Answer ans1 = new Answer();
		ans1.setAid(22);
		ans1.setAnswer("Prog. scripting language");
		ans1.setQ(q2);
		q2.setAnswer(ans1);

		Session s = factory.openSession();

		Transaction tx = s.beginTransaction();

		s.save(q1);
		s.save(q2);
		s.save(ans);
		s.save(ans1);

		tx.commit();
		
		// fetching
		
		Question qf = (Question)s.get(Question.class, 1);
		System.out.println(qf.getQuestion());
		System.out.println(qf.getAnswer().getAid());

		s.close();

		factory.close();
	}
}
