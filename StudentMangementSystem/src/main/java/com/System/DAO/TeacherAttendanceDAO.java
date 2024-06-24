package com.System.DAO;

import com.System.ModelClass.StudentAttendance;
import com.System.ModelClass.TeacherAttendance;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class TeacherAttendanceDAO {

    // Instance of SessionFactory to manage Hibernate sessions
    private final SessionFactory sessionFactory;

    // Constructor to initialize the SessionFactory
    public TeacherAttendanceDAO(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    /**
     * Method to save an attendance object into the database.
     * @param teacherAttendance: The attendance object to be saved.
     */
    public void saveTeacherAttendance(TeacherAttendance teacherAttendance){

        // Open a new session from the SessionFactory
        Session session = sessionFactory.openSession();

        // Begin a new transaction
        Transaction transaction = session.beginTransaction();

        // Save the attendance object using the persist method
        session.save(teacherAttendance);

        // Commit the transaction to save changes to the database
        transaction.commit();

        // Close the session to release database connection
        session.close();
    }

    // Method to get an attendance record by ID
    public TeacherAttendance getTeacherAttendanceById(int teacherAttendId) {

        //Open a new session from the SessionFactory
        Session session = sessionFactory.openSession();

        //Load the fetched parameters into an empty attendance object
        TeacherAttendance teacherAttendance = session.get(TeacherAttendance.class, teacherAttendId);

        //Close the session to release database connection
        session.close();

        //Return the newly constructed attendance object
        return teacherAttendance;
    }

    public void deleteTeacherAttendance(int teacherAttendId){

        // Open a new session from the SessionFactory
        Session session = sessionFactory.openSession();

        //Begin a new transaction
        Transaction transaction = session.beginTransaction();

        //Fetch the teacher attendance object using its ID
        TeacherAttendance teacherAttendance = session.get(TeacherAttendance.class, teacherAttendId);

        //Save the attendance object using the delete method
        if(teacherAttendance!= null){
            session.delete(teacherAttendance);
        }

        //Commit the transaction to save changes to the database
        transaction.commit();

        //Close the session to release database connection
        session.close();
    }

}
