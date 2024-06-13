package com.System.ModelClass;

//Imports
import jakarta.persistence.*;
import java.time.LocalTime;

//This class and database table originally named "Class.java" & "class"
//respectively, but were changed to avoid any conflicts due to
//class being a java keyword

//Declare the student class as an entity that maps to the school class table in the database
@Entity
@Table(name = "school_class")
public class SchoolClass {

    //Initialize Variable
    private Integer classId;
    private String className;
    private Integer teacherId;
    private LocalTime startTime;
    private LocalTime endTime;
    private Teacher teacher;

    //Constructor
    public SchoolClass(Integer classId, String className, Integer teacherId, LocalTime startTime, LocalTime endTime) {
        this.classId = classId;
        this.className = className;
        this.teacherId = teacherId;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    //Empty constructor for generated objects
    public SchoolClass() {
    }

    //Attributes' getters, setters, and database mappings

   //Added ID annotations that declare the attribute as the
   //ID column for the class as well as the generation type
   //of the attribute; in this case its IDENTITY which is handled by the database.
   //Column annotation that maps the attribute to the column name in the
   //database, and it can not be null
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "class_id", nullable = false)
    //Getter method for the class ID
    public Integer getClassId() {
        return classId;
    }

    //Setter method for the class ID
    public void setId(Integer classId) {
        this.classId = classId;
    }

    //Column annotation mapping the attribute to the class name column
    @Column(name = "class_name", length = 50)
    //Getter method for the class name
    public String getClassName() {
        return className;
    }

    //Setter method for the class name
    public void setClassName(String className) {
        this.className = className;
    }

    //Column annotation mapping the attribute to the teacher id column
    @Column(name = "teacher_id")
    //Getter method for the teacher ID
    public Integer getTeacherId() {
        return teacherId;
    }

    //Setter method for the teacher ID
    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    //Column annotation mapping the attribute to the start time column
    @Column(name = "start_time")
    //Getter method for the class start time
    public LocalTime getStartTime() {
        return startTime;
    }

    //Setter method for the class start time
    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    //Column annotation mapping the attribute to the end time column
    @Column(name = "end_time")
    //Getter method for the class end time
    public LocalTime getEndTime() {
        return endTime;
    }

    //Setter method for the class end time
    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    //Created Many to One relationship between the
    //teacher table and the school class table
    @ManyToOne
    @JoinColumn(name = "teacher_id", referencedColumnName = "teacher_id")
    //Getter method for a teacher object
    public Teacher getTeacher() {
        return teacher;
    }

    //Setter method for the teacher object
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString(){
        StringBuilder s = new StringBuilder();

        s.append("Class ID #").append(getClassId()).append("\n");
        s.append("Class Name: ").append(getClassName()).append("\n");
        //Use the teacher object to return the teacher's last name
        s.append("Teacher: ").append(getTeacher().getTeacherLastName()).append("\n");
        s.append("Class Time: ").append(getStartTime()).append("-").append(getEndTime());

        return s.toString();
    }
}