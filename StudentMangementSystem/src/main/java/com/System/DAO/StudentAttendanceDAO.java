package com.System.DAO;

import com.System.ModelClass.SchoolClass;
import com.System.ModelClass.StudentAttendance;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class StudentAttendanceDAO {

    // Instance of SessionFactory to manage Hibernate sessions
    private final SessionFactory sessionFactory;

    // Constructor to initialize the SessionFactory
    public StudentAttendanceDAO(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    /**
     * Method to save an attendance object into the database.
     * @param studentAttendance: The attendance object to be saved.
     */
    public void saveStudentAttendance(StudentAttendance studentAttendance){

        // Open a new session from the SessionFactory
        Session session = sessionFactory.openSession();

        // Begin a new transaction
        Transaction transaction = session.beginTransaction();

        // Save the attendance object using the save method
        session.save(studentAttendance);

        // Commit the transaction to save changes to the database
        transaction.commit();

        // Close the session to release database connection
        session.close();
    }

    public void deleteStudentAttendance(int studentAttendId){

        // Open a new session from the SessionFactory
        Session session = sessionFactory.openSession();

        //Begin a new transaction
        Transaction transaction = session.beginTransaction();

        //Fetch the student attendance object using its ID
        StudentAttendance studentAttendance = session.get(StudentAttendance.class, studentAttendId);

        //Save the attendance object using the delete method
        if(studentAttendance!= null){
            session.delete(studentAttendance);
        }

        //Commit the transaction to save changes to the database
        transaction.commit();

        //Close the session to release database connection
        session.close();
    }

    // Method to get an attendance record by ID
    public StudentAttendance getStudentAttendanceById(int studentAttendId) {

        //Open a new session from the SessionFactory
        Session session = sessionFactory.openSession();

        //Load the fetched parameters into an empty attendance object
        StudentAttendance studentAttendance = session.get(StudentAttendance.class, studentAttendId);

        //Close the session to release database connection
        session.close();

        //Return the newly constructed attendance object
        return studentAttendance;
    }
}
