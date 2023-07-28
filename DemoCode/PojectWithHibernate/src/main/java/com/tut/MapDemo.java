package com.tut;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
	        
	        Question q1=new Question();
//	        q1.setQid(10);
	        q1.setQuestion("Did you eat?");
	        Answer a1=new Answer();
//	        a1.setAid(10);
	        a1.setAnswer("Yes");
	        a1.setQ(q1);
	        Answer a2 = new Answer();
//	        a2.setAid(20);
	        a2.setAnswer("No");
	        a2.setQ(q1);
	        List<Answer> list = new ArrayList<Answer>();
	        
	        session.save(a1);
	        session.save(a2);
	        list.add(a1);
	        list.add(a2);
	        q1.setAns(list);
	        
	        session.save(q1);
//	        session.save(a1);
//	        session.save(a2);
	        
	        Question q=(Question)session.get(Question.class, 1);
	        System.out.println(q.getQuestion());
	        
	        for(Answer a:q.getAns())
	        	System.out.println(a.getAnswer());
	        
	        
	        tx.commit();
//	        session.close();
//	        factory.close();
	        
	    }
}
