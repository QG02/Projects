package DAO_Files;

import java.sql.*;

public final class DAOFactory {

    //Store database connection values in immutable variables
    private static final String PROPERTY_URL="url";
    private static final String PROPERTY_USERNAME="username";
    private static final String PROPERTY_PASSWORD="password";

   private final String url, username, password;


   private Connection conn = null;

   //DAO method to create the database connection
   public DAOFactory(String prefix) {

       DAOProperties properties = new DAOProperties(prefix);

       //Always use variables to hold connections or important values
       //for more code security
       this.url = properties.getProperty(PROPERTY_URL);
       this.username = properties.getProperty(PROPERTY_USERNAME);
       this.password = properties.getProperty(PROPERTY_PASSWORD);

       try {
           //Using the local host login data to create the connection
           conn = DriverManager.getConnection(url, username, password);
       } catch (SQLException e) {
           throw new DAOException(e.getMessage());
       }
   }

       //Connection get method
       Connection getConnection(){
           return conn;
       }

       //Added get method to return the studentDAO
       public StudentDAO getStudentDAO(){
            return new StudentDAO(this);
       }

       //Added get method to return the teacherDAO
       public TeacherDAO getTeacherDAO(){
            return new TeacherDAO(this);
       }

       //Added get method to return the ClassDAO
       public ClassDAO getClassDAO(){
            return new ClassDAO(this);
       }
}


