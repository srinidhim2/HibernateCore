package com.hql;

import java.util.Arrays;
import java.util.List;

import org.hibernate.query.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tut.Student;

public class HQLExample {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.getCurrentSession();
		Transaction tx= session.beginTransaction();
		
		//HQL
//		String query="from Student where city='Raichur'";
		
		
//		String query="from Student as s where s.city=:x";
//		
//		//Dynamically assigning parameters
//		Query q = session.createQuery(query);
//		q.setParameter("x", "Raichur");

		//Query can get single and multiple results
		//single-unique
		//multiple - list
		
//		List<Student> list = q.list();
//		
//		for(Student s:list) {
//			System.out.println(s.getName());
//		}
		
		//Delete
//		String query1 ="delete from Student where city=:c";
//		Query q1  = session.createQuery(query1);
//		q1.setParameter("c","Tumkur");
//		
//		q1.executeUpdate();
		
		//Update
//		String query2 ="update Student set city=:c where name=:n";
//		Query q2  = session.createQuery(query2);
//		q2.setParameter("c","Tumkur");
//		q2.setParameter("n", "Raki");
//		
//		
//		q2.executeUpdate();
		
		
		//Ececute Join Query
		
		String query3 = "Select q.question, a.answer from Question q INNER JOIN q.ans as a";
		Query q3 = session.createQuery(query3);
		List<Object[]> list3 = q3.list();
		
		for(Object[] a: list3) {
			System.out.println(Arrays.toString(a)+" "+ a[0]);
		}
		
		
		tx.commit();
		
		
		factory.close();
	}
}
