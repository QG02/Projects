package Tests;

import DAO_Files.ClassDAO;
import DAO_Files.DAOFactory;
import Source_Files.SchoolClass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ClassFindTest {

    private DAOFactory daoFactory;

    @BeforeEach
    public void setup(){
        daoFactory = new DAOFactory("tas.jdbc");
    }
    @Test
    public void findClassTest() {

        ClassDAO classDAO = daoFactory.getClassDAO();

        SchoolClass c1 = classDAO.find(101);

        assertEquals("Class ID #101\nClass Name: Biology\nTeacher: Johnson\nClass Time: 08:00:00-09:30:00", c1.toString());
    }
}