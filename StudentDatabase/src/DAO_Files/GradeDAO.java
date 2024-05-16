package DAO_Files;

import Source_Files.Grade;
import Source_Files.Student;

import java.sql.*;

public class GradeDAO {

    //Initializing the query as a constant outside the method body
    private static final String GradeQuery = "SELECT * FROM grades WHERE grade_id = ?";

    //Initialize DAOFactory object
    private final DAOFactory daoFactory;

    //Load into GradeDAO constructor
    public GradeDAO(DAOFactory daoFactory) {

        this.daoFactory = daoFactory;

    }

    //Grade.find(id) to retrieve student data associated with the ID
    public Grade find(int id){

        //Initialize empty class object
        Grade grade = null;
       //Initialize empty connection
        Connection conn = null;
        //Initialize empty prepared statement
        PreparedStatement ps = null;
        //Initialize empty result set
        ResultSet rs = null;

        try{

            //Get connection securely through a method
            conn = daoFactory.getConnection();

            //Validate connection
            boolean hasConn = (conn != null);
            if(hasConn){

                //Execute query
                ps = conn.prepareStatement(GradeQuery);
                //Start retrieving data starting at the id column
                ps.setInt(1,id);
                //Execute query
                rs = ps.executeQuery();

                //Validate result set
                boolean hasRS = (rs != null);
                if(hasRS){
                    //Start retrieving data
                    int gradeId = rs.getInt("grade_id");

                    //Creating a teacher object using the getStudentDAO method
                    StudentDAO studentDAO = daoFactory.getStudentDAO();
                    Student student = studentDAO.find(rs.getInt("student_id"));

                    //Retrieve the char value through a String
                    char gradeRecord = rs.getString("grade").charAt(0);
                    Date dateRecord = rs.getDate("date_recorded");

                     //Create new grade object using the parameters
                    grade = new Grade(gradeId, student, gradeRecord, dateRecord);

                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return grade;
    }
}
