package com.System;

import com.System.DAO.StudentDAO;
import com.System.ModelClass.Student;
import com.System.Util.HibernateUtil;
import org.hibernate.SessionFactory;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        // Initialize the Hibernate session factory
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        // Initialize the StudentDAO
        StudentDAO studentDAO = new StudentDAO(sessionFactory);
        // Create a new student and save it to the database
        Student newStudent = new Student();
        newStudent = studentDAO.getStudentById(200);
        System.out.println(newStudent.toString());
    }
}