package com.System.DAO;

import com.System.ModelClass.StudentAttendance;
import com.System.Util.HibernateUtil;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS) // Indicates that the test class will have a single instance
public class StudentAttendanceDAOTest{

    private SessionFactory sessionFactory;
    private StudentAttendanceDAO studentAttendanceDAO;

    @BeforeAll
    public void setUp() {

        // Set up the Hibernate session factory before all tests
        sessionFactory = HibernateUtil.getSessionFactory();
        // Initialize the StudentAttendanceDAO with the session factory
        studentAttendanceDAO = new StudentAttendanceDAO(sessionFactory);

    }

    @AfterAll
    public void tearDown() {

        // Close the session factory after all tests to release resources
        if (sessionFactory != null) {
            sessionFactory.close();
        }

    }

    @Test
    public void saveStudentAttendance() {

        // Create a new attendance object
        StudentAttendance studentAttendance = new StudentAttendance();
        // Save the attendance record using the StudentAttendanceDAO
        studentAttendanceDAO.saveStudentAttendance(studentAttendance);

        // Assert that the attendance ID is not null after saving
        assertNotNull(studentAttendance.getStudentAttendId(), "Attendance ID should not be null after saving");

    }

    @Test
    public void getStudentAttendanceById() {

        // Fetch an attendance record by ID using the StudentAttendanceDAO
        StudentAttendance a1 = studentAttendanceDAO.getStudentAttendanceById(10);

        // Assert that the fetched record's details match the expected values
        assertEquals("Student Attendance ID #10\n"+
                "Student: Cain Jessica\n"+
                "Class ID #110\n"+
                "Date Recorded: 2024-05-01\n"+
                "Status: Absent", a1.toString());
    }
}
