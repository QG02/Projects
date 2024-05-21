package Source_Files;

import java.sql.Date;
import java.util.HashMap;

//Define Student Class
public class Student {
    private final int studentID;
    private final String first_name;
    private final String last_name;
    private final Date date_of_birth;
    private final String gender;
    private final String address;
    private final String email;
    private final String phoneNumber;

    //Initializing a constructor for the student object using a String HashMap
    //Make sure the parameters match the name of the columns in the Student table
    public Student(HashMap<String, String> parameters){
        this.studentID = Integer.parseInt(parameters.get("student_id"));
        this.first_name = parameters.get("first_name");
        this.last_name = parameters.get("last_name");
        this.date_of_birth = Date.valueOf(parameters.get("date_of_birth"));
        this.gender = parameters.get("gender");
        this.address = parameters.get("address");
        this.email = parameters.get("email");
        this.phoneNumber = parameters.get("phone_number");
    }

    //Getter methods
    public int getStudent_id() {
        return studentID;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public Date getDate_of_birth() {
        return date_of_birth;
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

    }
}



