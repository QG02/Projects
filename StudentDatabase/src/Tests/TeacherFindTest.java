package Tests;

import DAO_Files.DAOFactory;
import DAO_Files.TeacherDAO;
import Source_Files.Teacher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TeacherFindTest {

    private DAOFactory daoFactory;

    @BeforeEach
    public void setup(){
        daoFactory = new DAOFactory("tas.jdbc");
    }

    @Test
    public void findTeacherTest(){

        TeacherDAO teacherDAO = daoFactory.getTeacherDAO();

        Teacher t1 = teacherDAO.find(1);

        assertEquals("Teacher ID #1\nTeacher Name: Emily Johnson\nEmail: emjohnson@gmail.com\nSpecialization: Biology", t1.toString());
    }

}