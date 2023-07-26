package com.tut;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
        System.out.println( "Project Started" );
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory= cfg.buildSessionFactory();
//        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        System.out.println(factory);
        
        Student st= new Student();
//        st.setId(2);
        st.setName("John");
        st.setCity("Delhi");
        System.out.println(st);
        
        
        Address ad = new Address();
        ad.setStreet("street1");
        ad.setCity("Tumkur");
        ad.setOpen(true);
        ad.setAddedDate(new Date());
        ad.setX(124.3);
        
        
        //Reading image
        FileInputStream fis = new FileInputStream("C:\\Users\\Srinidhi M\\ECWS\\HBORM\\PojectWithHibernate\\src\\main\\java\\com\\tut\\a.png");
        byte[] data = new byte[fis.available()];
        fis.read(data);
        ad.setImage(data);
        
        //Saving student object in db
        Session session= factory.getCurrentSession();
        Transaction tx=session.beginTransaction();
        
        
        session.save(st);
        session.save(ad);
        
        tx.commit();

        
        
        session.close();
        System.out.println("Done");
    }
}
