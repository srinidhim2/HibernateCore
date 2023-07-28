package com.pagination;

import org.hibernate.query.*;

import com.tut.Student;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HQLPagination {
public static void main(String[] args) {
	SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	Session session = factory.getCurrentSession();
	Transaction tx= session.beginTransaction();
	
	
	String query= "from Student";
	
	Query q = session.createQuery(query);
	q.setFirstResult(5);
	q.setMaxResults(6);
	
	List<Student> list = q.list();
	
	for(Student s:list) {
		System.out.println(s.getName());
	}
	
	tx.commit();
	
	
	factory.close();
}
}
