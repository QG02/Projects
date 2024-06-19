package com.System.DAO;

import com.System.ModelClass.Student;
import com.System.Util.HibernateUtil;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class StudentDAOTest {

    private SessionFactory sessionFactory;
    private StudentDAO studentDAO;

    @BeforeAll
    public void setUp() {
        sessionFactory = HibernateUtil.getSessionFactory();
        studentDAO = new StudentDAO(sessionFactory);
    }

    @AfterAll
    public void tearDown() {
        if(sessionFactory != null) {
            sessionFactory.close();
        }
    }

    @Test
    public void testSaveStudent() {
        Student student = new Student(null, "John", "Doe", LocalDate.of(2000, 1, 1), "Male", "123 Street", "john.doe@example.com", "1234567890");
        studentDAO.saveStudent(student);

        assertNotNull(student.getStudentId(), "Student ID should not be null after saving");
    }

    @Test
    public void testGetStudentById() {

        Student s1 = studentDAO.getStudentById(200);

        assertEquals("Student ID #200\n" +
                "Student Name: Victoria Mannix\n" +
                        "Date of Birth: 2024-09-22\n" +
                "Gender: Female\n" +
                "Address: 774-1125 Et, St.\n" +
                "Email: dolor@hotmail.net\n" +
                "Phone Number: 0-272-264-1818\n", s1.toString());
    }
}
