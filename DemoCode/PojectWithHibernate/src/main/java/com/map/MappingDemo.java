package com.map;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tut.Question;

public class MappingDemo {
	public static void main(String[] args) {
		SessionFactory factory= new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		Emp e1 = new Emp();
//		e1.setEid(1);
		e1.setName("Mukesh");
		Emp e2 = new Emp();
//		e2.setEid(2);
		e2.setName("Naresh");
		
		Project p1 = new Project();
//		p1.setPid(3);
		p1.setProjectName("Hospital");
		Project p2 = new Project();
//		p2.setPid(2);
		p2.setProjectName("School");
		
		List<Project> p = new ArrayList();
		List<Emp> e = new ArrayList<Emp>();
		
		p.add(p1);
		p.add(p2);
		e.add(e1);
		e.add(e2);
		
		e1.setProjects(p);
		e2.setProjects(p);
		p2.setEmp(e);
		p1.setEmp(e);
		
		session.save(e1);
		session.save(e2);
		session.save(p1);
		session.save(p2);
		
//		Project pp = (Project)session.get(Project.class, 1);
//		session.remove(pp); //delete
		tx.commit();
		session.close();
	}
}
