package com.System.DAO;

import com.System.ModelClass.Student;
import com.System.ModelClass.Teacher;
import com.System.Util.HibernateUtil;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;

@TestInstance(TestInstance.Lifecycle.PER_CLASS) // Indicates that the test class will have a single instance
public class TeacherDAOTest {

    private SessionFactory sessionFactory;
    private TeacherDAO teacherDAO;

    @BeforeAll
    public void setUp() {

        // Set up the Hibernate session factory before all tests
        sessionFactory = HibernateUtil.getSessionFactory();
        // Initialize the TeacherDAO with the session factory
        teacherDAO = new TeacherDAO(sessionFactory);

    }

    @AfterAll
    public void tearDown() {

        // Close the session factory after all tests to release resources
        if (sessionFactory != null) {
            sessionFactory.close();
        }

    }

    @Test
    public void testSaveTeacher() {

        // Create a new Teacher object
        Teacher teacher = new Teacher(null, "John", "Doe", "johnDOE@gmail.com", "Mathematics" );
        // Save the student using the StudentDAO
        teacherDAO.saveTeacher(teacher);

        // Assert that the student ID is not null after saving
        assertNotNull(teacher.getTeacherId(), "Teacher ID should not be null after saving");

    }

    @Test
    public void testGetTeacherById() {

        // Fetch a teacher by ID using the TeacherDAO
        Teacher t1 = teacherDAO.getTeacherById(20);

        // Assert that the fetched teacher's details match the expected values
        assertEquals("Teacher ID #20\n" +
                "Teacher Name: Alexander Gutierrez\n" +
                "Email: agutierrez@outlook.com\n" +
                "Specialization: Linguistics", t1.toString());

    }
}
