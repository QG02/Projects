package com.System.ModelClass;

//Imports
import jakarta.persistence.*;
import java.time.LocalDate;

//Declare the teacher attendance as an entity that maps to the teacher attendance table in the database
@Entity
@Table(name = "teacher_attendance")
public class TeacherAttendance {

    //Initialize Variables
    private Integer teacherAttendId;
    private Teacher teacher;
    private LocalDate dateRecord;
    private String status;

    //Constructor
    public TeacherAttendance(Integer teacherAttendId, Teacher teacher, LocalDate dateRecord, String status) {
        this.teacherAttendId = teacherAttendId;
        this.teacher = teacher;
        this.dateRecord = dateRecord;
        this.status = status;
    }

    //Empty constructor for generated objects
    public TeacherAttendance(){}

    //Attributes' getters, setters, and database mappings

    //Added ID annotations that declare the attribute as the
    //ID column for the class as well as the generation type
    //of the attribute; in this case its IDENTITY which is handled by the database.
    //Column annotation that maps the attribute to the column name in the
    //database, and it can not be null
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attendance_id", nullable = false)
    //Getter method for the teacher attendance ID
    public Integer getTeacherAttendId() {
        return teacherAttendId;
    }

    //Setter Method for the teacher attendance ID
    public void setTeacherAttendId(Integer teacherAttendId) {
        this.teacherAttendId = teacherAttendId;
    }

    //Created Many to One relationship between the
    //attendance table and teacher table
    @ManyToOne
    @JoinColumn(name = "teacher_id", referencedColumnName = "teacher_id")
   //Getter method for the teacher ID
    public Teacher getTeacher() {
        return teacher;
    }

    //Setter method for the teacher ID
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    //Column annotation mapping the attribute to the date recorded column
    @Column(name = "teacherAttend_date_record")
    //Getter method for the date recorded
    public LocalDate getTeacherDateRecord() {
        return dateRecord;
    }

    //Setter method for the date recorded
    public void setTeacherDateRecord(LocalDate dateRecord) {
        this.dateRecord = dateRecord;
    }

    //Column annotation mapping the attribute to the status column
    @Column(name = "teacher_status", length = 10)
    //Getter method for the status
    public String getTeacherAttendStatus() {
        return status;
    }

    //Setter method for the status
    public void setTeacherAttendStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString(){

        StringBuilder s = new StringBuilder();

        s.append("Teacher Attendance ID #").append(getTeacherAttendId()).append("\n");
        s.append("Teacher: ").append(getTeacher().getTeacherLastName()).append("\n");
        s.append("Date Recorded: ").append(getTeacherDateRecord()).append("\n");
        s.append("Status: ").append(getTeacherAttendStatus());

        return s.toString();
    }
}