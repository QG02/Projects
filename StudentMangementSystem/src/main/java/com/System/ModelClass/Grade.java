package com.System.ModelClass;

//Imports
import jakarta.persistence.*;
import java.time.LocalDate;

//Declare the grade class as an entity that maps to the grade table in the database
@Entity
@Table(name = "grades")
public class Grade {

    //Initialize Variables
    private Integer gradeId;
    private Integer studentId;
    private Integer classId;
    private String grade;
    private LocalDate dateRecorded;

    //Constructor
    public Grade(Integer gradeId, Integer studentId, Integer classId, String grade, LocalDate dateRecorded) {
        this.gradeId = gradeId;
        this.studentId = studentId;
        this.classId = classId;
        this.grade = grade;
        this.dateRecorded = dateRecorded;
    }

    //Empty constructor for generated objects
    public Grade(){
    }

    //Attributes' getters, setters, and database mappings

    //Added ID annotations that declare the attribute as the
    //ID column for the class as well as the generation type
    //of the attribute; in this case its IDENTITY which is handled by the database.
    //Column annotation that maps the attribute to the column name in the
    //database, and it can not be null
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "grade_id", nullable = false)
    //Getter method for the grade ID
    public Integer getGradeId() {
        return gradeId;
    }

    //Setter method for the grade ID
    public void setGradeId(Integer gradeId) {
        this.gradeId = gradeId;
    }


    //Column annotation mapping the attribute to the student name column
    @Column(name = "student_id")
    //Getter method for the student ID
    public Integer getStudentId() {
        return studentId;
    }

    //Setter method for the student ID
    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    //Column annotation mapping the attribute to the class id column from the class table
    @Column(name = "class_id")
    //Getter method for the class ID
    public Integer getClassId() {
        return classId;
    }

    //Setter method for the class ID
    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    //Column annotation mapping the attribute to the grade column
    @Column(name = "grade", length = 2)
    //Getter method for the grade
    public String getGrade() {
        return grade;
    }

    //Setter method for the grade
    public void setGrade(String grade) {
        this.grade = grade;
    }

    //Column annotation mapping the attribute to the date recorded column
    @Column(name = "grade_date_recorded")
    //Getter method for the date recorded
    public LocalDate getDateRecorded() {
        return dateRecorded;
    }

    //Setter method for the date recorded
    public void setDateRecorded(LocalDate dateRecorded) {
        this.dateRecorded = dateRecorded;
    }

    @Override
    public String toString(){
        StringBuilder s = new StringBuilder();

        s.append("Grade ID #").append(getGradeId()).append("\n");
        s.append("Student ID #").append(getStudentId()).append("\n");
        s.append("Class ID #").append(getClassId()).append("\n");
        s.append("Assigned Grade: ").append(getGrade()).append("\n");
        s.append("Recorded: ").append(getDateRecorded());

        return s.toString();
    }
}
