package com.hibernate.demo.student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		
		 //create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
        
        Session session = factory.getCurrentSession();
         
        try{
            
            //create a student object
            System.out.println("Creating new Student Object....");
            Student theStudent = new Student( "Tahir", "Korejo", "tahirkorejo@gmail.com");
            
            //start a transaction
            session.beginTransaction();
            
            //save the student object
            System.out.println("saving the Student");
            session.save(theStudent);
            
            //commit transaction
            session.getTransaction().commit();
            
            //Done
            System.err.println("Done....!");
        }finally{
          factory.close();
        }

	}

}
