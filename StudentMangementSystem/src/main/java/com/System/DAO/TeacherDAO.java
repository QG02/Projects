package com.System.DAO;

import com.System.ModelClass.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class TeacherDAO {

    // Instance of SessionFactory to manage Hibernate sessions
    private final SessionFactory sessionFactory;

    // Constructor to initialize the SessionFactory
    public TeacherDAO(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    /**
     * Method to save a Teacher object into the database.
     * @param teacher: The teacher object to be saved.
     */
    public void saveTeacher(Teacher teacher){

        // Open a new session from the SessionFactory
        Session session = sessionFactory.openSession();

        // Begin a new transaction
        Transaction transaction = session.beginTransaction();

        // Save the teacher object using the persist method
        session.save(teacher);

        // Commit the transaction to save changes to the database
        transaction.commit();

        // Close the session to release database connection
        session.close();
    }

    // Method to get a teacher by ID
    public Teacher getTeacherById(int teacherId) {

        //Open a new session from the SessionFactory
        Session session = sessionFactory.openSession();

        //Load the fetched parameters into an empty teacher object
        Teacher teacher = session.get(Teacher.class, teacherId);

        //Close the session to release database connection
        session.close();

        //Return the newly constructed teacher object
        return teacher;
    }
}
