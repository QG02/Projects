package com.System.ModelClass;

//Imports
import jakarta.persistence.*;
import java.time.LocalDate;

//Declare the student class as an entity that maps to the student table in the database
@Entity
@Table(name = "student")
public class Student{

    //Initialize Variables
    private Integer studentId;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String gender;
    private String address;
    private String email;
    private String phoneNumber;

    //Constructor
    public Student(Integer studentId, String firstName, String lastName, LocalDate dateOfBirth, String gender, String address, String email, String phoneNumber){
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    //Empty constructor for generated objects
    public Student(){
    }

    //Attributes' getters, setters, and database mappings

    //Added ID annotations that declare the attribute as the
    //ID column for the class as well as the generation type
    //of the attribute; in this case its IDENTITY which is handled by the database.
    //Column annotation that maps the attribute to the column name in the
    //database, and it can not be null
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id", nullable = false)
    //Getter method for the student ID
    public Integer getStudentId() {
        return studentId;
    }

    //Setter method for the student ID
    public void setStudentId(Integer studentId){
        this.studentId = studentId;
    }

    //Column annotation mapping the attribute to the first name column
    @Column(name = "student_first_name", length = 50)
    //Getter method for the student's first name
    public String getStudentFirstName() {
        return firstName;
    }

    //Setter method for the student's last name
    public void setStudentFirstName(String firstName){
        this.firstName = firstName;
    }

    //Column annotation mapping the attribute to the last name column
    @Column(name = "student_last_name", length = 50)
    //Getter method for the student's last name
    public String getStudentLastName() {
        return lastName;
    }

    //Setter method for the student's last name
    public void setStudentLastName(String lastName){
        this.lastName = lastName;
    }

    //Column annotation mapping the attribute to the date of birth column
    @Column(name = "date_of_birth")

    //Getter method for the student's date of birth
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    //Setter method for the student's date of birth
    public void setDateOfBirth(LocalDate dateOfBirth){
        this.dateOfBirth = dateOfBirth;
    }

    //Column annotation mapping the attribute to the gender column
    @Column(name = "gender", length = 6)
    //Getter method for the student's gender
    public String getGender() {
        return gender;
    }

    //Setter method for the student's gender
    public void setGender(String gender){
        this.gender = gender;
    }

    //Column annotation mapping the attribute to the address column
    @Column(name = "address", length = 100)
    //Getter method for the student's address
    public String getAddress() {
        return address;
    }

    //Setter method for the student's address
    public void setAddress(String address){
        this.address = address;
    }

    //Column annotation mapping the attribute to the email column
    @Column(name = "student_email", length = 50)
    //Getter method for the student's email
    public String getStudentEmail() {
        return email;
    }

    //Setter method for the student's email
    public void setStudentEmail(String email) {
        this.email = email;
    }

    //Column annotation mapping the attribute to the phone number column
    @Column(name = "phone_number", length = 15)
    //Getter method for the student's phone number
    public String getPhoneNumber() {
        return phoneNumber;
    }

    //Setter method for the student's phone number
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString(){
        StringBuilder s = new StringBuilder();

        s.append("Student ID #").append(getStudentId()).append("\n");
        s.append("Student Name: ").append(getStudentFirstName()).append(" ").append(getStudentLastName()).append("\n");
        s.append("Date of Birth: ").append(getDateOfBirth()).append("\n");
        s.append("Gender: ").append(getGender()).append("\n");
        s.append("Address: ").append(getAddress()).append("\n");
        s.append("Email: ").append(getStudentEmail()).append("\n");
        s.append("Phone Number: ").append(getPhoneNumber());

        return s.toString();
    }
}