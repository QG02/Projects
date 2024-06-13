package com.System.ModelClass;

//Imports
import jakarta.persistence.*;
import java.time.LocalDate;

//Declare the student attendance as an entity that maps to the student attendance table in the database
@Entity
@Table(name = "student_attendance")
public class StudentAttendance {

    //Initialize Variables
    private Integer studentAttendId;
    private Integer studentId;
    private Integer classId;
    private LocalDate dateRecord;
    private String status;

    //Constructor
    public StudentAttendance(Integer studentAttendId, Integer studentId, Integer classId, LocalDate dateRecord, String status) {
        this.studentAttendId = studentAttendId;
        this.studentId = studentId;
        this.classId = classId;
        this.dateRecord = dateRecord;
        this.status = status;
    }

    //Empty constructor for generated objects
    public StudentAttendance(){}

    //Attributes' getters, setters, and database mappings

    //Added ID annotations that declare the attribute as the
    //ID column for the class as well as the generation type
    //of the attribute; in this case its IDENTITY which is handled by the database.
    //Column annotation that maps the attribute to the column name in the
    //database, and it can not be null
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attendance_id", nullable = false)
    //Getter method for the student attendance ID
    public Integer getStudentAttendId() {
        return studentAttendId;
    }

    //Setter method for the student attendance ID
    public void setId(Integer studentAttendId) {
        this.studentAttendId = studentAttendId;
    }


    //Column annotation mapping the attribute to the student's id column from the student table
    @Column(name = "student_id")
    //Getter method for the student ID
    public Integer getStudentId() {
        return studentId;
    }

    //Setter method for the student ID
    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    //Column annotation mapping the attribute to the class's id column from the schoolClass table
    @Column(name = "class_id")
    //Getter method for the class ID
    public Integer getClassId() {
        return classId;
    }

    //Setter method for the class ID
    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    //Column annotation mapping the attribute to the date recorded column
    @Column(name = "studentAttend_date_record")
    //Getter method for the date recorded ID
    public LocalDate getStudentAttendRecord() {
        return dateRecord;
    }

    //Setter method for the date recorded ID
    public void setStudentAttendRecord(LocalDate dateRecord) {
        this.dateRecord = dateRecord;
    }

    @Column(name = "status", length = 10)
    //Getter method for the status
    public String getStudentAttendStatus() {
        return status;
    }

    //Setter method for the status
    public void setStudentAttendStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString(){
        StringBuilder s = new StringBuilder();

        s.append("Student Attendance ID #").append(getStudentAttendId()).append("\n");
        s.append("Student ID #").append(getStudentId()).append("\n");
        s.append("Class ID #").append(getClassId()).append("\n");
        s.append("Date Recorded: ").append(getStudentAttendRecord()).append("\n");
        s.append("Status: ").append(getStudentAttendStatus()).append("\n");

        return s.toString();
    }

}