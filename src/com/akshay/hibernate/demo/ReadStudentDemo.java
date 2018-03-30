package com.akshay.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.akshay.hibernate.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		//create session factory
		
		SessionFactory factory = new Configuration()
									.configure()
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();	
		//create session
		 Session session = factory.getCurrentSession();
		try {
			System.out.println("Begin transaction");
			session.beginTransaction();
//			System.out.println("Save student");
//			session.save(new Student("vivek","singh","akshay.gautam2209"));
			System.out.println("Read student");
			Student student = session.get(Student.class, 4);
			System.out.println(student);
			System.out.println("commit transaction");
			session.getTransaction().commit();
			System.out.println("Done");
		}catch(Exception e){
			
		}finally {
			session.close();
		}

	}

}
