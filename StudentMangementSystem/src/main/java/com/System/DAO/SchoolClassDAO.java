package com.System.DAO;

import com.System.ModelClass.SchoolClass;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class SchoolClassDAO {

    // Instance of SessionFactory to manage Hibernate sessions
    private final SessionFactory sessionFactory;

    // Constructor to initialize the SessionFactory
    public SchoolClassDAO(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    /**
     * Method to save a Student object into the database.
     * @param schoolClass: The student object to be saved.
     */
    public void saveSchoolClass(SchoolClass schoolClass){

        // Open a new session from the SessionFactory
        Session session = sessionFactory.openSession();

        // Begin a new transaction
        Transaction transaction = session.beginTransaction();

        // Save the class object using the persist method
        session.save(schoolClass);

        // Commit the transaction to save changes to the database
        transaction.commit();

        // Close the session to release database connection
        session.close();
    }

    // Method to get a student by ID
    public SchoolClass getSchoolClassById(int classId) {

        //Open a new session from the SessionFactory
        Session session = sessionFactory.openSession();

        //Load the fetched parameters into an empty student object
        SchoolClass schoolClass = session.get(SchoolClass.class, classId);

        //Close the session to release database connection
        session.close();

        //Return the newly constructed teacher object
        return schoolClass;
    }
}