package DAO_Files;

import Source_Files.Grade;
import Source_Files.Student;

import java.sql.*;

public class GradeDAO {

    private static final String GradeQuery = "SELECT * FROM grades WHERE grade_id = ?";

    private final DAOFactory daoFactory;

    public GradeDAO(DAOFactory daoFactory) {

        this.daoFactory = daoFactory;

    }

    public Grade find(int id){

        Grade grade = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try{
            conn = daoFactory.getConnection();

            if(conn != null){

                ps = conn.prepareStatement(GradeQuery);
                ps.setInt(1,id);
                rs = ps.executeQuery();

                if(rs.next()){

                    int gradeId = rs.getInt("grade_id");

                    StudentDAO studentDAO = daoFactory.getStudentDAO();
                    Student student = studentDAO.find(rs.getInt("student_id"));

                    String charValue = rs.getString("grade");
                    if(charValue != null && !charValue.isEmpty()){
                        char gradeValue = charValue.charAt(0);
                    }

                    Date dateRecord = rs.getDate("date_recorded");


                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return grade;
    }
}
