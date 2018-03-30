package com.akshay.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.akshay.hibernate.entity.Student;

public class DeleteStudentDemo {

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
			System.out.println("Read student");
			Student student = session.get(Student.class, 3);
			System.out.println(student);
			System.out.println("Deleting student");
			
			session.delete(student);
			
			System.out.println("commit transaction");
			session.getTransaction().commit();
			System.out.println("Done");
			System.out.println("--------------New Session--------------------");
			
			session = factory.getCurrentSession();
			System.out.println("Begin transaction");
			session.beginTransaction();
			System.out.println("Deleting student");
			session.createQuery("delete Student where id = 4").executeUpdate();
			session.getTransaction().commit();
			System.out.println("Done");
		}catch(Exception e){
			
		}finally {
			session.close();
		}

	}

}
