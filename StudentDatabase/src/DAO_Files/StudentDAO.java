package DAO_Files;

import Source_Files.Student;
import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;

public class StudentDAO {


    //Initializing the query as a constant outside the method body
    private static final String StudentQuery = "SELECT * FROM student WHERE student_id = ?";

    //Initialize DAOFactory object
    private final DAOFactory daoFactory;

    //Load into StudentDAO constructor
    public StudentDAO(DAOFactory daoFactory) {

        this.daoFactory = daoFactory;

    }

    //Student.find(id) to retrieve student data associated with the ID
    public Student find(int id) {

        //Initialize empty student object
        Student student = null;
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
                ps = conn.prepareStatement(StudentQuery);
                //Start retrieving data starting at the id column
                ps.setInt(1,id);
                //Execute query
                rs = ps.executeQuery();

                //Validate result set
                boolean hasRS = (rs != null);
                if(hasRS && rs.next()){

                    //Load the hashmap as parameters to pass it into the empty student object
                    HashMap<String, String> parameters = new HashMap<String, String>();
                    parameters.put("studentId", Integer.toString(rs.getInt("student_id")));
                    parameters.put("firstName", rs.getString("first_name"));
                    parameters.put("lastName", rs.getString("last_name"));
                    parameters.put("dob", rs.getDate("date_of_birth").toString());

                    int gender = rs.getInt("gender");
                    parameters.put("gender", String.valueOf(gender));

                    parameters.put("address", rs.getString("address"));
                    parameters.put("email", rs.getString("email"));
                    parameters.put("phone", rs.getString("phone"));

                    //Create new student object using the parameters
                    student = new Student(parameters);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
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
        return student;
    }
}
