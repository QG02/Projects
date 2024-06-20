package com.System.DAO;

import com.System.ModelClass.TeacherAttendance;
import com.System.Util.HibernateUtil;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS) // Indicates that the test class will have a single instance
public class TeacherAttendanceDAOTest{

    private SessionFactory sessionFactory;
    private TeacherAttendanceDAO teacherAttendanceDAO;

    @BeforeAll
    public void setUp() {

        // Set up the Hibernate session factory before all tests
        sessionFactory = HibernateUtil.getSessionFactory();
        // Initialize the TeacherAttendanceDAO with the session factory
        teacherAttendanceDAO = new TeacherAttendanceDAO(sessionFactory);

    }

    @AfterAll
    public void tearDown() {

        // Close the session factory after all tests to release resources
        if (sessionFactory != null) {
            sessionFactory.close();
        }

    }

    @Test
    public void testSaveTeacherAttendance() {

        // Create a new attendance object
        TeacherAttendance teacherAttendance = new TeacherAttendance();
        // Save the attendance record using the TeacherAttendanceDAO
        teacherAttendanceDAO.saveTeacherAttendance(teacherAttendance);

        // Assert that the attendance ID is not null after saving
        assertNotNull(teacherAttendance.getTeacherAttendId(), "Attendance ID should not be null after saving");

    }

    @Test
    public void testGetAttendanceById() {

        // Fetch an attendance record by ID using the StudentAttendanceDAO
        TeacherAttendance t1 = teacherAttendanceDAO.getTeacherAttendanceById(10);

        // Assert that the fetched record's details match the expected values
        assertEquals("Teacher Attendance ID #10\n"+
                "Teacher: Hernandez\n"+
                "Date Recorded: 2024-05-01\n"+
                "Status: Present", t1.toString());
    }
}
