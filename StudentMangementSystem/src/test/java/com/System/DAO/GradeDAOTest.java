package com.System.DAO;

import com.System.ModelClass.Grade;
import com.System.Util.HibernateUtil;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS) // Indicates that the test class will have a single instance
public class GradeDAOTest{

    private SessionFactory sessionFactory;
    private GradeDAO gradeDAO;

    @BeforeAll
    public void setUp() {

        // Set up the Hibernate session factory before all tests
        sessionFactory = HibernateUtil.getSessionFactory();
        // Initialize the grade with the session factory
        gradeDAO = new GradeDAO(sessionFactory);

    }

    @AfterAll
    public void tearDown() {

        // Close the session factory after all tests to release resources
        if (sessionFactory != null) {
            sessionFactory.close();
        }

    }

    @Test
    public void testSaveGrade() {

        // Create a new grade object
        Grade grade = new Grade();
        // Save the grade using the GradeDAO
        gradeDAO.saveGrade(grade);

        // Assert that the student ID is not null after saving
        assertNotNull(grade.getGradeId(), "Grade ID should not be null after saving");

    }

    @Test
    public void testDeleteGrade(){

        //Create a new grade object and save it to the database
        Grade g1 = new Grade(null, 94, 102, null, null);

        //Store the object inside a DAO
        gradeDAO.saveGrade(g1);

        Integer gradeId = g1.getGradeId();
        assertNotNull(gradeId, "Grade ID should not be null after saving");

        gradeDAO.deleteGrade(gradeId);

        Grade deletedGrade = gradeDAO.getGradeById(gradeId);
        assertNull(deletedGrade, "Grade should be null");
    }

    @Test
    public void testGetGradeById() {

        // Fetch a grade by ID using the gradeDAO
        Grade g1 = gradeDAO.getGradeById(5);

        // Assert that the fetched grade's details match the expected values
        assertEquals("Grade ID #5\n" +
                "Student ID #90\n" +
                "Class ID #105\n" +
                "Assigned Grade: A\n" +
                "Recorded: 2024-04-15",
                g1.toString());
    }
}
