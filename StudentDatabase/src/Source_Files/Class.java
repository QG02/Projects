package Source_Files;

import java.sql.Time;

public class Class {
    private final int classID;
    private final String className;
    private final Teacher teacher;
    private final Time startTime;
    private final Time endTime;

    public Class(int classID, String className, Teacher teacher, Time startTime, Time endTime){
        this.classID = classID;
        this.className = className;
        this.teacher = teacher;
        this.startTime = startTime;
        this.endTime = endTime;
    }


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
