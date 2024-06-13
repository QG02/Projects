package com.System.ModelClass;

//Imports
import jakarta.persistence.*;

//Declare the teacher class as an entity that maps to the teacher table in the database
@Entity
@Table(name = "teacher")
public class Teacher {

    //Initialize Variables
    private Integer teacherId;
    private String firstName;
    private String lastName;
    private String email;
    private String specialization;

    //Constructor
    public Teacher(Integer teacherId, String firstName, String lastName, String email, String specialization) {
        this.teacherId = teacherId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.specialization = specialization;
    }

    //Empty constructor for generated objects
    public Teacher(){}

    //Attributes' getters, setters, and database mappings

    //Added ID annotations that declare the attribute as the
    //ID column for the class as well as the generation type
    //of the attribute; in this case its IDENTITY which is handled by the database.
    //Column annotation that maps the attribute to the column name in the
    //database, and it can not be null
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teacher_id", nullable = false)
    //Getter method for the teacher ID
    public Integer getTeacherId() {
        return teacherId;
    }

    //Setter method for the teacher ID
    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }


    //Column annotation mapping the attribute to the teacher's first name column
    @Column(name = "teacher_first_name", length = 50)
    //Getter method for the teacher's first name
    public String getTeacherFirstName() {
        return firstName;
    }

    //Setter method for the teacher's first name
    public void setTeacherFirstName(String firstName) {
        this.firstName = firstName;
    }

    //Column annotation mapping the attribute to the teacher's last name column
    @Column(name = "teacher_last_name", length = 50)
    //Getter method for the teacher's last name
    public String getTeacherLastName() {
        return lastName;
    }

    //Setter method for the teacher's last name
    public void setTeacherLastName(String lastName) {
        this.lastName = lastName;
    }

    //Column annotation mapping the attribute to the email column
    @Column(name = "teacher_email", length = 50)
    //Getter method for the teacher email
    public String getTeacherEmail() {
        return email;
    }

    //Setter method for the teacher email
    public void setTeacherEmail(String email) {
        this.email = email;
    }

    //Column annotation mapping the attribute to the specialization column
    @Column(name = "specialization", length = 100)
    //Getter method for the teacher specialization
    public String getSpecialization() {
        return specialization;
    }

    //Setter method for the teacher specialization
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    @Override
    public String toString(){
        StringBuilder s = new StringBuilder();

        s.append("Teacher ID #").append(getTeacherId()).append("\n");
        s.append("Teacher Name: ").append(getTeacherFirstName()).append(" ").append(getTeacherLastName()).append("\n");
        s.append("Email: ").append(getTeacherEmail()).append("\n");
        s.append("Specialization: ").append(getSpecialization());

        return s.toString();
    }
}
