package com.hql;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tut.Answer;
import com.tut.Question;

public class CascadeExample {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.getCurrentSession();
		Transaction tx= session.beginTransaction();
		
		Question q = new Question();
		q.setQid(556);
		q.setQuestion("what is cascading");
		
		Answer a1= new Answer();
		Answer a2 = new Answer();
		Answer a3 = new Answer();
		a1.setAnswer("a");
		a1.setQ(q);
		a2.setAnswer("b");
		a2.setQ(q);
		a3.setAnswer("c");
		a3.setQ(q);
		List<Answer> list = new ArrayList<Answer>();
		list.add(a1);
		list.add(a2);
		list.add(a3);
		q.setAns(list);
		
		session.save(q);
		session.remove(q);
		tx.commit();
		factory.close();
	}
}
