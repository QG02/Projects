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
     * Method to save a class object into the database.
     * @param schoolClass: The class object to be saved.
     */
    public void saveSchoolClass(SchoolClass schoolClass){

        // Open a new session from the SessionFactory
        Session session = sessionFactory.openSession();

        // Begin a new transaction
        Transaction transaction = session.beginTransaction();

        // Save the class object using the save method
        session.save(schoolClass);

        // Commit the transaction to save changes to the database
        transaction.commit();

        // Close the session to release database connection
        session.close();
    }

    public void deleteSchoolClass(int classId){

        // Open a new session from the SessionFactory
        Session session = sessionFactory.openSession();

        //Begin a new transaction
        Transaction transaction = session.beginTransaction();

        //Fetch the school class object using its ID
        SchoolClass schoolClass = session.get(SchoolClass.class, classId);

        //Delete the class object using the delete method
        if(schoolClass != null){
            session.delete(schoolClass);
        }

        //Commit the transaction to save changes to the database
        transaction.commit();

        //Close the session to release database connection
        session.close();
    }

      // Method to get a class by ID
    public SchoolClass getSchoolClassById(int classId) {

        //Open a new session from the SessionFactory
        Session session = sessionFactory.openSession();

        //Load the fetched parameters into an empty class object
        SchoolClass schoolClass = session.get(SchoolClass.class, classId);

        //Close the session to release database connection
        session.close();

        //Return the newly constructed class object
        return schoolClass;
    }
}
