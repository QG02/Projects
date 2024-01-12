package StudentProj;

import java.util.Scanner;
import java.util.Random;

public class Student {
    //Create a Student class with the properties studentID (int), name (string), degree
    //(string), mobile (string). 
    private int studentID;
    private String name;
    private String degree;
    private String mobileNum;
    

    /*
     * b) Create a constructor for the Student class to set values for name, degree and mobile
        number.
     */
    //CONSTRUCTOR __________________________________________________
    //studentID does not have to be passed an arguement in the constructor 
    //since it will be generated randomly with every instance of the contrustor
    public Student(String name, String degree, String mobileNum){
        Random random = new Random();
        this.studentID = random.nextInt(100) + 1;
        this.name = name;
        this.degree = degree;
        this.mobileNum = mobileNum;
    }
    //_________________________________________________________________
    //c) Create setters and getters for name, degree and mobile
    //SETTERS
    void setName(String name){
        this.name = name;
    }
    void setDegree(String degree){
        this.degree = degree;
    }
    void setMobileNum(String mobileNum){
        this.mobileNum = mobileNum;
    }
    //______________________________________________________
    //GETTERS
    public String getName(){
        return this.name;
    }

    public String getDegree(){
        return this.degree;
    }

    public String getMobileNum(){
        return this.mobileNum;
    }

    public int getStudentID(){
        return studentID;
    }
    //___________________________________________________________
    // d) Create a print() method to print details of a student.
    public String toString(){
        return "Student ID number: " + getStudentID() + "\nStudent name: " + getName() + "\nStudent degree: " + getDegree() + "\nStudent number: " + getMobileNum();
    }
    //______________________________________________________________
    //this has been chagned
    //this will be changed again

}

