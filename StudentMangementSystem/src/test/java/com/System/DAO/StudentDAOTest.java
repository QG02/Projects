package com.System.DAO;

import com.System.ModelClass.Student;
import com.System.Util.HibernateUtil;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;

@TestInstance(TestInstance.Lifecycle.PER_CLASS) // Indicates that the test class will have a single instance
public class StudentDAOTest {

    private SessionFactory sessionFactory;
    private StudentDAO studentDAO;

    @BeforeAll
    public void setUp() {
        
        // Set up the Hibernate session factory before all tests
        sessionFactory = HibernateUtil.getSessionFactory();
        // Initialize the StudentDAO with the session factory
        studentDAO = new StudentDAO(sessionFactory);
    
    }

    @AfterAll
    public void tearDown() {
     
        // Close the session factory after all tests to release resources
        if (sessionFactory != null) {
            sessionFactory.close();
        }
        
    }

    @Test
    public void testSaveStudent() {
        
        // Create a new Student object
        Student student = new Student(null, "John", "Doe", LocalDate.of(2000, 1, 1), "Male", "123 Street", "john.doe@example.com", "1234567890");
        // Save the student using the StudentDAO
        studentDAO.saveStudent(student);

        // Assert that the student ID is not null after saving
        assertNotNull(student.getStudentId(), "Student ID should not be null after saving");
    
    }

    @Test
    public void testGetStudentById() {
    
        // Fetch a student by ID using the StudentDAO
        Student s1 = studentDAO.getStudentById(200);

        // Assert that the fetched student's details match the expected values
        assertEquals("Student ID #200\n" +
                "Student Name: Victoria Mannix\n" +
                "Date of Birth: 2024-09-22\n" +
                "Gender: Female\n" +
                "Address: 774-1125 Et, St.\n" +
                "Email: dolor@hotmail.net\n" +
                "Phone Number: 0-272-264-1818", s1.toString());
    }
}
