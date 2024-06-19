package com.System.DAO;

import com.System.ModelClass.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class StudentDAO {

    // Instance of SessionFactory to manage Hibernate sessions
    private final SessionFactory sessionFactory;

    // Constructor to initialize the SessionFactory
    public StudentDAO(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

      /**
     * Method to save a Student object into the database.
     * @param student: The student object to be saved.
     */
    public void saveStudent(Student student){
        // Open a new session from the SessionFactory
        Session session = sessionFactory.openSession();

        // Begin a new transaction
        Transaction transaction = session.beginTransaction();

        // Save the student object using the persist method
        session.save(student);

        // Commit the transaction to save changes to the database
        transaction.commit();

        // Close the session to release database connection
        session.close();
    }

    // Method to get a student by ID
    public Student getStudentById(int studentId) {
        Session session = sessionFactory.openSession();
        Student student = session.get(Student.class, studentId);
        session.close();
        return student;
    }
}
