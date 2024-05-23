package Source_Files;

import java.sql.Date;
import java.util.HashMap;

//Define Student Class
public class Student {
    private final int studentID;
    private final String firstName;
    private final String lastName;
    private final Date dateOfBirth;
    private final String gender;
    private final String address;
    private final String email;
    private final String phoneNumber;

    //Initializing a constructor for the student object using a String HashMap
    //Make sure the parameters match the name of the columns in the Student table
    public Student(HashMap<String, String> parameters){
        this.studentID = Integer.parseInt(parameters.get("student_id"));
        this.firstName = parameters.get("first_name");
        this.lastName = parameters.get("last_name");
        this.dateOfBirth = Date.valueOf(parameters.get("date_of_birth"));
        this.gender = parameters.get("gender");
        this.address = parameters.get("address");
        this.email = parameters.get("email");
        this.phoneNumber = parameters.get("phone_number");
    }

    //Getter methods
    public int getStudentID() {
        return studentID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString(){
        StringBuilder s = new StringBuilder();

        s.append("Student ID #").append(studentID).append("\n");
        s.append("Student Name: ").append(firstName).append(" ").append(lastName).append("\n");
        s.append("Date of Birth: ").append(dateOfBirth).append("\n");
        s.append("Gender: ").append(gender).append("\n");
        s.append("Address: ").append(address).append("\n");
        s.append("Email: ").append(email).append("\n");
        s.append("Phone Number: ").append(phoneNumber);

        return s.toString();
    }
}



