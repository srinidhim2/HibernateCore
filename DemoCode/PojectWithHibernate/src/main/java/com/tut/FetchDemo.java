package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class FetchDemo {
	public static void main(String[] args) {
		//get and load
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session= factory.getCurrentSession();
	    Transaction tx= session.beginTransaction();
		
	    //get
		Student st= (Student)session.get(Student.class, 1);
		//load
		Address ad =(Address)session.load(Address.class,1);
		
		System.out.println(ad.getCity());
		System.out.println(st);
	}
}
