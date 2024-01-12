package StudentProj;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
//f) Create a separate class called StudentApp with the main method.

public class StudentApp {
    private Scanner sc = new Scanner(System.in);
    private List<Student> studentList;

    //creating the project as an object that will be tested in another file
    public StudentApp(){
        this.studentList = new ArrayList<>();
        initializeStudents();
    }

    //g) Create an array of Student of objects. Instantiate 5 Student objects using the 
    //constructors and the setters you have developed. 
    public void initializeStudents(){
        Student student1 = new Student("Bob Bobs","Computer Science","256-565-0952");
        Student student2 = new Student("Homer Simpson","Mathematics","256-235-3421");
        Student student3 = new Student("Adam Sandler","Busines","208-323-2111");
        Student student4 = new Student("Thomas Blue","Music","881-231-0992");
        Student student5 = new Student("Mike Oxhert","Agriculture","633-504-4531");

        addStudentToList(student1);
        addStudentToList(student2);
        addStudentToList(student3);
        addStudentToList(student4);
        addStudentToList(student5);
    }
    
    //this method will add any student objects to the list as long as the attributes are not null
    public void addStudentToList(Student student){
        if(student != null){
            studentList.add(student);
        }
    }
    
    //this method is called when the user wants to add a new student to the program
    public void addNewStudent(Student student){
        System.out.println("To add a new student, please provide the following in order: ");
        System.out.println("Student name.");
        System.out.println("User input: ");
        String nameToAdd = sc.next();
        System.out.println();
        System.out.println("Student phone number(ex.123-456-7890).");
        System.out.println("User input: ");
        String phoneNumToAdd = sc.next();
        System.out.println();
        System.out.println("Student degree.");
        System.out.println("User input: ");
        String degreeToAdd = sc.next();
        System.out.println();
        Student newStudent = new Student(nameToAdd, phoneNumToAdd, degreeToAdd);
        addStudentToList(newStudent);
        System.out.println("Student has been added.\nAn ID number will be assigned at random for each student.");
    }
    public Student searchStudentID(int studentID){
        Student studentFound = null;
        for(Student student : studentList){
            if(!isEmptyString(studentID) && studentID == student.getStudentID()){
                studentFound = student;
            }
        }
        return studentFound;
    }

    public static boolean isEmptyString(int input) {
		return (input == 0);
	}

    //when called, this method will ask the user for the ID number of the student to be removed
    public void removeStudentFromList(Student student){
        System.out.println("To remove student data from the list,\nPlease provide the student's ID number:");
        int studentIDtoRemove = sc.nextInt();
        Student studentToRemove = searchStudentID(studentIDtoRemove);
        if(studentToRemove != null){
            studentList.remove(studentToRemove);
            System.out.println("Student removed.");
        }else{
            System.out.println("Student not found.");
        }
    }
    //h) Display the details of all the 5 students making use of the for loop.
    public void displayStudents(){
        System.out.println("Students currently enrolled:");
        System.out.println("-----------------------------");
        for(Student student : studentList){
            System.out.println("Student name: " + student.getName());
            System.out.println("Student ID: " + student.getStudentID());
            System.out.println("Student degree: " + student.getDegree());
            System.out.println("Student phone number: " + student.getMobileNum());
            System.out.println("-----------------------------------");
        }
    }
    private boolean AuthenticateUser(){
        boolean userAutherization = false;
        System.out.println("You must enter the correct username and password to access the program.");
        System.out.println("Please enter the username.");
        System.out.println("User input: ");
        String inputUsername = sc.nextLine();
        System.out.println("Please enter the password.");
        System.out.println("User input: ");
        String inputPassword = sc.nextLine();
        if(inputUsername.equals("QG02") && inputPassword.equals("123456*")){
            userAutherization = true;
            System.out.println("Access approved!");
            System.out.println();
        } else {
            System.out.println("Access denied.");
        } return userAutherization;

    }
    public void runStudentList(){
        int choice;
        boolean userAutherization = AuthenticateUser();

        while(userAutherization){
            System.out.println("This is the student list.");
            System.out.println("________________________________________");
            System.out.println("Enter the number that corresponds to the action you would like to perform.");
            System.out.println();
            System.out.println("1. Display students list.");
            System.out.println("2. Add new student to the list.");
            System.out.println("3. Remove a student from the list.");
            System.out.println("4. Exit program.");
            System.out.println();
            System.out.println("User Input: ");
            choice = sc.nextInt();

            switch(choice){
                case 1: //Display students list.
                displayStudents();
                break;
                //---------------------
                case 2: //Add new student to the list.
                String c2;
                do{
                    Student newStudent = new Student(null,null,null);
                    addNewStudent(newStudent);
                    System.out.println("Do you want to add another student? ");
                    System.out.println("(Yes/yes) or (No/no)");
                    System.out.println("User input: ");
                    c2 = sc.nextLine();
                }while(c2.equalsIgnoreCase("yes"));
                break;
                //---------------------
                case 3: //Remove a student from the list.
                String c3;
                do{
                    Student studentRemoved = new Student(null, null, null);
                    removeStudentFromList(studentRemoved);
                    System.out.println("Do you want to remove another student? ");
                    System.out.println("(Yes/yes) or (No/no)");
                    System.out.println("User input: ");
                    c3 = sc.nextLine();
                }while(c3.equalsIgnoreCase("yes"));
                break;
                //---------------------
                case 4: //Exit program
                System.out.println("Exiting program...");
                userAutherization = false;
                sc.close();
                System.exit(0);
                break;
            }
        }
    }
}