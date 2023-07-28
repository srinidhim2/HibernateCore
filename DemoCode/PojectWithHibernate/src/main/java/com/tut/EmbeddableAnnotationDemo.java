package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmbeddableAnnotationDemo {
	public static void main(String[] args) {
		//get and load
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
//		Session session= factory.getCurrentSession();
//	    Transaction tx= session.beginTransaction();
		
		Student s1 = new Student();
		s1.setName("Tiwari");
		s1.setCity("Blore");
		 
		Certificate c = new Certificate("Android","2 Months");
		s1.setCerti(c);
		
		Student s2 = new Student();
		s2.setName("Tandeep");
		s2.setCity("Mlore");
		s2.setCerti(c);
		
		Session s= factory.openSession();
		Transaction tx=s.beginTransaction();
		s.save(s1);
		s.save(s2);
		tx.commit();
		
		
		
		s.close();
		factory.close();
	}
}
