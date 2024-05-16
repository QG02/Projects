package DAO_Files;

import Source_Files.Teacher;

import javax.xml.transform.Result;
import java.sql.*;

public class TeacherDAO {

    private static final String TeacherQuery = "SELECT * FROM teacher WHERE teacher_id = ?";

    private final DAOFactory daoFactory;

    public TeacherDAO(DAOFactory daoFactory) {

        this.daoFactory = daoFactory;

    }

    public Teacher find(int id){

        Teacher teacher = null;
        ResultSet rs = null;
        PreparedStatement ps = null;

        try {
            Connection conn = daoFactory.getConnection();
            if (conn != null) {
                ps = conn.prepareStatement(TeacherQuery);
                ps.setInt(1, id);
            }
        }catch (SQLException e){
            throw new DAOException(e.getMessage());
        } finally

    }
}
