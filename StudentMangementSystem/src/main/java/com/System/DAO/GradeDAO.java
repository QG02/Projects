package com.System.DAO;

import com.System.ModelClass.Grade;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class GradeDAO {

    // Instance of SessionFactory to manage Hibernate sessions
    private final SessionFactory sessionFactory;

    // Constructor to initialize the SessionFactory
    public GradeDAO(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    /**
     * Method to save a grade object into the database.
     * @param grade: The grade object to be saved.
     */
    public void saveGrade(Grade grade){

        // Open a new session from the SessionFactory
        Session session = sessionFactory.openSession();

        // Begin a new transaction
        Transaction transaction = session.beginTransaction();

        // Save the grade object using the persist method
        session.save(grade);

        // Commit the transaction to save changes to the database
        transaction.commit();

        // Close the session to release database connection
        session.close();
    }

    // Method to get a grade by ID
    public Grade getGradeById(int gradeId) {

        //Open a new session from the SessionFactory
        Session session = sessionFactory.openSession();

        //Load the fetched parameters into an empty grade object
        Grade grade = session.get(Grade.class, gradeId);

        //Close the session to release database connection
        session.close();

        //Return the newly constructed grade object
        return grade;
    }

    public void deleteGrade(int gradeId){

        //New session created
        Session session = sessionFactory.openSession();

        //New transaction started in the session
        Transaction transaction = session.beginTransaction();

        //Fetches and stores the object value to be deleted
        Grade grade = session.get(Grade.class, gradeId);

        //Deletes grade object
        session.delete(grade);

        //Commit transaction
        transaction.commit();

        //Close session
        session.close();
    }
}
