package DAO_Files;

import Source_Files.SchoolClass;
import Source_Files.Teacher;
import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ClassDAO {

    private static final String ClassQuery = "SELECT * FROM school_class WHERE class_id =?";

    private final DAOFactory daoFactory;

    public ClassDAO(DAOFactory daoFactory){
        this.daoFactory = daoFactory;
    }

    public SchoolClass find(int id){

        SchoolClass classInfo = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try{

            conn = daoFactory.getConnection();

            if(conn != null){

                ps = conn.prepareStatement(ClassQuery);
                ps.setInt(1,id);
                rs = ps.executeQuery();

                if(rs.next()){

                    int classId = rs.getInt("class_id");
                    String className = rs.getString("class_name");

                    TeacherDAO teacherDAO = daoFactory.getTeacherDAO();
                    Teacher teacher = teacherDAO.find(rs.getInt("teacher_id"));

                    Time startTime = rs.getTime("start_time");
                    Time endTime = rs.getTime("end_time");

                    classInfo = new SchoolClass(classId, className, teacher, startTime, endTime);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return classInfo;
    }
}
