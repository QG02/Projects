package DAO_Files;

import Source_Files.Teacher;
import java.sql.*;

public class TeacherDAO {

    //Initializing the query as a constant outside the method body
    private static final String TeacherQuery = "SELECT * FROM teacher WHERE teacher_id = ?";

    //Initialize DAOFactory object
    private final DAOFactory daoFactory;

    //Load into TeacherDAO constructor
    public TeacherDAO(DAOFactory daoFactory) {

        this.daoFactory = daoFactory;

    }

    //Teacher.find(id) to retrieve student data associated with the ID
    public Teacher find(int id) {

        //Initialize empty teacher object
        Teacher teacher = null;
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

                //Pass the query into the prepared statement
                ps = conn.prepareStatement(TeacherQuery);
                //Start retrieving data starting at the id column
                ps.setInt(1,id);
                //Execute query
                rs = ps.executeQuery();

                //Validate result set
                boolean hasRS = (rs != null);
                if(hasRS && rs.next()){

                    //Start retrieving data
                    int teacherID = rs.getInt("teacher_id");
                    String firstName = rs.getString("first_name");
                    String lastName = rs.getString("last_name");
                    String email = rs.getString("email");
                    String specialization = rs.getString("specialization");

                    //Create new teacher object using the parameters
                    teacher = new Teacher(teacherID, firstName, lastName, email, specialization);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            // Close resources in finally block to ensure they are closed even if an exception occurs
            if (rs != null) {
                try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
            }
            if (ps != null) {
                try { ps.close(); } catch (SQLException e) { e.printStackTrace(); }
            }
            if (conn != null) {
                try { conn.close(); } catch (SQLException e) { e.printStackTrace(); }
            }
        }

        return teacher;
    }
}
