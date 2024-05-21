package Source_Files;

//Define Teacher Class
public class Teacher {
    private final int teacherID;
    private final String first_name;
    private final String last_name;
    private final String email;
    private final String specialization;

    //Initialize constructor
    public Teacher(int teacherID, String first_name, String last_name, String email, String specialization) {
        this.teacherID = teacherID;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.specialization = specialization;
    }

    //Getter methods
    public int getTeacherID() {
        return teacherID;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getEmail() {
        return email;
    }

    public String getSpecialization() {
        return specialization;
    }

    @Override
    public String toString(){

    }
}
