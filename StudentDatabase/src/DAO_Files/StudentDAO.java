package DAO_Files;

import Source_Files.Student;
import java.sql.*;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;

public class StudentDAO {

    private static final String StudentQuery = "SELECT * FROM student WHERE student_id = ?";

    private final DAOFactory daoFactory;

    public StudentDAO(DAOFactory daoFactory) {

        this.daoFactory = daoFactory;

    }

    public Student find(int id) {

        Student student = null;
        ResultSet rs = null;
        PreparedStatement ps = null;

        try {

            Connection conn = daoFactory.getConnection();
            if (conn != null) {

                ps = conn.prepareStatement(StudentQuery);
                ps.setInt(1, id);
                rs = ps.executeQuery();

                if (rs.next()) {
                    HashMap<String, String> parameters = new HashMap<String, String>();
                    parameters.put("student_id", Integer.toString(rs.getInt("student_id")));
                    parameters.put("first_name", rs.getString("first_name"));
                    parameters.put("last_name", rs.getString("last_name"));
                    parameters.put("date_of_birth", rs.getDate("date_of_birth").toString());

                    int gender = rs.getInt("gender");
                    parameters.put("gender", String.valueOf(gender));

                    parameters.put("address", rs.getString("address"));
                    parameters.put("email", rs.getString("email"));
                    parameters.put("phone", rs.getString("phone"));

                    student = new Student(parameters);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return student;
    }
}
