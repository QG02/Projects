package com.System.DAO;

import com.System.ModelClass.SchoolClass;
import com.System.Util.HibernateUtil;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalTime;

@TestInstance(TestInstance.Lifecycle.PER_CLASS) // Indicates that the test class will have a single instance
public class SchoolClassDAOTest{

    private SessionFactory sessionFactory;
    private SchoolClassDAO schoolClassDAO;

    @BeforeAll
    public void setUp() {

        // Set up the Hibernate session factory before all tests
        sessionFactory = HibernateUtil.getSessionFactory();
        // Initialize the SchoolClassDAO with the session factory
        schoolClassDAO = new SchoolClassDAO(sessionFactory);

    }

    @AfterAll
    public void tearDown() {

        // Close the session factory after all tests to release resources
        if (sessionFactory != null) {
            sessionFactory.close();
        }

    }

    @Test
    public void testSaveSchoolClass() {

        // Create a new school class object
        SchoolClass schoolClass = new SchoolClass();
        // Save the school class using the SchoolClassDAO
        schoolClassDAO.saveSchoolClass(schoolClass);

        // Assert that the student ID is not null after saving
        assertNotNull(schoolClass.getClassId(), "Class ID should not be null after saving");

    }

    @Test
    public void testGetClassById() {

        // Fetch a school class by ID using the SchoolCLassDAO
        SchoolClass c1 = schoolClassDAO.getSchoolClassById(103);

        // Assert that the fetched class's details match the expected values
        assertEquals("Class ID #103\n" +
                "Class Name: English\n" +
                "Teacher: Brown\n" +
                "Class Time: 11:30:00-13:00:00", c1.toString());
    }

    @Test
    public void testDeleteClass(){

        //Fetch a school class by ID using the SchoolClassDAO
        SchoolClass c2 = new SchoolClass(null, "PE", 20, LocalTime.of(10,0,0), LocalTime.of(11,0,0));

        schoolClassDAO.saveSchoolClass(c2);
        assertNotNull(c2.getClassId(), "Class ID should not be null");

        schoolClassDAO.saveSchoolClass(c2);

        schoolClassDAO.deleteSchoolClass(c2.getClassId());
        assertNull(c2.getClassId(),"Class ID should be null");
    }
}
