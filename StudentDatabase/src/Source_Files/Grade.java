package Source_Files;

import java.sql.*;

//Define Grade class
public class Grade {
    private final int gradeID;
    private final Student student;
    private final char grade;
    private final Date dateRecorded;

    //Initialize Grade object constructor
    public Grade(int gradeID, Student student, char grade, Date dateRecorded){
        this.gradeID = gradeID;
        this.student = student;
        this.grade = grade;
        this.dateRecorded = dateRecorded;
    }

    //Getter methods
    public int getGradeID() {
        return gradeID;
    }

    public Student getStudent() {
        return student;
    }

    public char getGrade() {
        return grade;
    }

    public Date getDateRecorded() {
        return dateRecorded;
    }

    @Override
    public String toString(){
        StringBuilder s = new StringBuilder();

        s.append("Grade ID #").append(gradeID).append(", ");
        s.append("Student ID #").append(student.getStudentID()).append(", ");
        s.append("Assigned Grade: ").append(grade).append(", ");
        s.append("Recorded: ").append(dateRecorded);

        return s.toString();
    }
}
