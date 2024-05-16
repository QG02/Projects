package Source_Files;

import java.sql.Time;

//Define SchoolClass Class
//Originally intended to be class "Class.java"
//but due to class being a key word in Java
//it was changed to "SchoolClass.java"
public class SchoolClass {
    private final int classID;
    private final String className;
    private final Teacher teacher;
    private final Time startTime;
    private final Time endTime;

    //Initialize constructor
    public SchoolClass(int classID, String className, Teacher teacher, Time startTime, Time endTime){
        this.classID = classID;
        this.className = className;
        this.teacher = teacher;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    //Getter method
    public int getClassID() {
        return classID;
    }

    public String getClassName() {
        return className;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public Time getStartTime() {
        return startTime;
    }

    public Time getEndTime() {
        return endTime;
    }
}
