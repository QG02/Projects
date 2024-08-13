package com.GymManagement.DTO;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "classes")
public class Session {

    //ATTRIBUTE MAPPING
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "class_id", nullable = false)
    private Integer sessionId;

    @Column(name = "class_name")
    private String sessionName;

    @Column(name = "class_instructor")
    private String sessionInstructor;

    @Column(name = "class_schedule")
    private String sessionSchedule;

    @Column(name = "class_location")
    private String sessionLocation;

    @OneToMany(mappedBy = "session")
    private Set<Enrollment> sessionEnrollments = new LinkedHashSet<>();


    //GETTER METHODS
    public Integer getSessionId() {
        return sessionId;
    }

    public String getSessionName() {
        return sessionName;
    }

    public String getSessionInstructor() {
        return sessionInstructor;
    }

    public String getSessionSchedule() {
        return sessionSchedule;
    }

    public String getSessionLocation() {
        return sessionLocation;
    }

    public Set<Enrollment> getSessionEnrollments() {
        return sessionEnrollments;
    }

    //SETTER METHODS
    public void setSessionId(Integer sessionId) {
        this.sessionId = sessionId;
    }

    public void setSessionName(String sessionName) {
        this.sessionName = sessionName;
    }

    public void setSessionInstructor(String sessionInstructor) {
        this.sessionInstructor = sessionInstructor;
    }

    public void setSessionSchedule(String sessionSchedule) {
        this.sessionSchedule = sessionSchedule;
    }

    public void setSessionLocation(String sessionLocation) {
        this.sessionLocation = sessionLocation;
    }

    public void setEnrollments(Set<Enrollment> sessionEnrollments) {
        this.sessionEnrollments = sessionEnrollments;
    }

}