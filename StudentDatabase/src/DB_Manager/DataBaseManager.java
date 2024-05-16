package DB_Manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Database manager file that directly handles the login info for the localhost in the MySQL session
public class DataBaseManager{
    public static void main(String[] args){
        String url = "jdbc:mysql://localhost:3306/testdb";
        String user = "StudentProj";
        String password = "1234";

        //Validates the database connection
        try(Connection conn = DriverManager.getConnection(url, user, password)){
            System.out.println("Connected to database");
        } catch (SQLException e) {
            System.out.println("Error connecting to database");
            e.printStackTrace();
        }
    }
}
