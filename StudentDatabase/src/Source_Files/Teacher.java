package Source_Files;

//Define Teacher Class
public class Teacher {
    private final int teacherID;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String specialization;

    //Initialize constructor
    public Teacher(int teacherID, String firstName, String lastName, String email, String specialization) {
        this.teacherID = teacherID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.specialization = specialization;
    }

    //Getter methods
    public int getTeacherID() {
        return teacherID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getSpecialization() {
        return specialization;
    }

    @Override
    public String toString(){
        StringBuilder s = new StringBuilder();

        s.append("Teacher ID #: ").append(teacherID).append("\n");
        s.append("Teacher Name: ").append(firstName).append(" ").append(lastName).append("\n");
        s.append("Email: ").append(email).append("\n");
        s.append("Specialization: ").append(specialization);

        return s.toString();
    }
}
