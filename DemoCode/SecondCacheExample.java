package com.cache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tut.Student;

public class SecondCacheExample {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.getCurrentSession();
		Transaction tx= session.beginTransaction();
		
		
		
		Student st = (Student)session.get(Student.class, 1);
		System.out.println(st);
		
		
		session.close();
	
	
		Session session1 = factory.getCurrentSession();
		
		Student st1 = (Student)session.get(Student.class, 1);
		System.out.println(st1);
		
		
		session1.close();
	}
}
