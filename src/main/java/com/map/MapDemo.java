package com.map;

import java.util.ArrayList;
import java.util.List;

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
		Answer ans1 = new Answer();
		ans1.setAid(12);
		ans1.setAnswer("Prog. scripting language");
		ans1.setQ(q1);
		Answer ans13 = new Answer();
		ans13.setAid(13);
		ans13.setAnswer("Prog. java scripting language");
		ans13.setQ(q1);
		
		
		List<Answer> ll = new ArrayList<Answer>();
		ll.add(ans);
		ll.add(ans1);
		ll.add(ans13);
		
		q1.setAnswer(ll);
		
		
//		
//		// Create question
//		Question q2 = new Question();
//		q2.setQid(2);
//		q2.setQuestion("What is python?");

		// creating answer;
//		Answer ans1 = new Answer();
//		ans1.setAid(11);
//		ans1.setAnswer("Prog. scripting language");
//		ans1.setQ(q1);
		//q2.setAnswer(ans1);

		Session s = factory.openSession();

		Transaction tx = s.beginTransaction();

//		s.save(q1);
//		s.save(ans);
//		s.save(ans13);
//		s.save(ans1);
//		
		

		tx.commit();
		
		// fetching
		
		Question qf = (Question)s.get(Question.class, 1);
		System.out.println(qf.getQuestion());
		
		for(Answer a : qf.getAnswer())
			System.out.println(a.getAnswer());

		s.close();

		factory.close();
	}
}
