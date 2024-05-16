package Source_Files;

import java.sql.*;

public class Grade {
    private final int gradeID;
    private final Student student;
    private final char grade;
    private final Date date_recorded;

    public Grade(int gradeID, Student student, char grade, Date date_recorded){
        this.gradeID = gradeID;
        this.student = student;
        this.grade = grade;
        this.date_recorded = date_recorded;
    }

    public int getGradeID() {
        return gradeID;
    }

    public Student getStudent() {
        return student;
    }

    public char getGrade() {
        return grade;
    }

    public Date getDate_recorded() {
        return date_recorded;
    }
}
