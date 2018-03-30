package com.akshay.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.akshay.hibernate.entity.Student;

public class QueryStudentDemo {

	@SuppressWarnings("unchecked")
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
			//Query all students
			List<Student> studentList  = session.createQuery("from Student").list();
			displayStudents(studentList);
			
			//Query students where
			List<Student> studentGautam =  session.createQuery("from Student s where s.lastName = 'Gautam'").list();
			displayStudents(studentGautam);
			
			//Query Students OR
			List<Student> studentOr =  session.createQuery("from Student s where s.lastName = 'Gautam' OR s.firstName ='vivek'").list();
			displayStudents(studentOr);
			
			//Query Student Like
			List<Student> studentLike =  session.createQuery("from Student s where s.lastName = 'Gautam' OR s.firstName Like '%aj%'").list();
			displayStudents(studentLike);
			
			System.out.println("commit transaction");
			session.getTransaction().commit();
			System.out.println("Done");
		}catch(Exception e){
			
		}finally {
			session.close();
		}

	}

	private static void displayStudents(List<Student> studentList) {
		for(Student student : studentList) {
			System.out.println(student);
		}
	}

}
