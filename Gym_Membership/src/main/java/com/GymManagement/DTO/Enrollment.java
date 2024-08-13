package com.GymManagement.DTO;

import com.GymManagement.DTO.Member.Member;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "enrollment")
public class Enrollment {

    //ATTRIBUTE MAPPING
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "enrollment_id", nullable = false)
    private Integer enrollmentId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "class_id", nullable = false)
    private Session session;

    @Column(name = "enrollment_date")
    private LocalDate enrollmentDate;

    //GETTER METHODS
    public Integer getId() {
        return enrollmentId;
    }

    public Member getMember() {
        return member;
    }

    public Session getSession() {
        return session;
    }

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    //SETTER METHODS
    public void setId(Integer enrollmentId) {
        this.enrollmentId = enrollmentId;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public void setEnrollmentDate(LocalDate enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

}