package DAO_Files;

import Source_Files.SchoolClass;
import Source_Files.Teacher;
import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ClassDAO {

    //Initializing the query as a constant outside the method body
    private static final String ClassQuery = "SELECT * FROM school_class WHERE class_id =?";

    private final DAOFactory daoFactory;

    //Initialize ClassDAO constructor
    public ClassDAO(DAOFactory daoFactory){
        this.daoFactory = daoFactory;
    }

    //SchoolClass.find(id) to retrieve student data associated with the ID
    public SchoolClass find(int id){

        //Initialize empty class object
        SchoolClass classInfo = null;
        //empty connection
        Connection conn = null;
        //empty prepared statement
        PreparedStatement ps = null;
        //empty result set
        ResultSet rs = null;

        try{

            //get connection securely through a method
            conn = daoFactory.getConnection();

            //validate connection
            boolean hasConn = (conn != null);
            if(hasConn){

                //Pass the query into the prepared statement
                ps = conn.prepareStatement(ClassQuery);
                //Start retrieving data starting at the id column
                ps.setInt(1,id);
                //Execute query
                rs = ps.executeQuery();

                //Validate result set
                boolean hasRS = (rs != null);
                if(hasRS && rs.next()){
                    //Start retrieving data
                    int classId = rs.getInt("class_id");
                    String className = rs.getString("class_name");

                    //Creating a teacher object using the getTeacherDAO method
                    TeacherDAO teacherDAO = daoFactory.getTeacherDAO();
                    Teacher teacher = teacherDAO.find(rs.getInt("teacher_id"));

                    Time startTime = rs.getTime("start_time");
                    Time endTime = rs.getTime("end_time");

                    //Populate the empty object with retrieved data
                    classInfo = new SchoolClass(classId, className, teacher, startTime, endTime);
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
        return classInfo;
    }
}
