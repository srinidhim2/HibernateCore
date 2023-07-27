package com.tut;

import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {
	 public static void main( String[] args ) throws IOException
	    {
	        System.out.println( "Project Started" );
	        Configuration cfg = new Configuration();
	        cfg.configure("hibernate.cfg.xml");
	        SessionFactory factory= cfg.buildSessionFactory();
	        
	        Session session= factory.getCurrentSession();
	        Transaction tx=session.beginTransaction();
	        
	        Answer a1= new Answer();
//	        a1.setAid(2);
	        a1.setAnswer("I am me");
	        
	        Question q1 = new Question();
//	        q1.setQid(1);
	        q1.setQuestion("Who are you");
	        
	        q1.setAns(a1);
	        a1.setQ(q1);
	        session.save(a1);
	        session.save(q1);
	        
	        Question q =(Question)session.get(Question.class, 3);
	        System.out.println(q.getQuestion());
	        System.out.println(q.getAns().getAnswer());
	        
	        tx.commit();
//	        session.close();
//	        factory.close();
	        
	    }
}
