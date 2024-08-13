package com.GymManagement.DTO.Staff;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "staff")
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "staff_id", nullable = false)
    private Integer staffId;

    @Column(name = "first_name")
    private String staffFN;

    @Column(name = "last_name")
    private String staffLN;

    @Column(name = "date_of_birth")
    private LocalDate staffDOB;

    @Column(name = "email")
    private String staffEmail;

    @Column(name = "phone", length = 20)
    private String staffPhone;

    @Embedded
    private StaffAddress staffAddress;

    @Embedded
    private StaffBank staffBank;

    @OneToMany(mappedBy = "staff")
    private Set<Employment> employments = new LinkedHashSet<>();

    //GETTER METHODS
    public Integer getStaffId() {
        return staffId;
    }

    public String getStaffFN() {
        return staffFN;
    }

    public String getStaffLN() {
        return staffLN;
    }

    public LocalDate getStaffDOB() {
        return staffDOB;
    }

    public String getStaffEmail() {
        return staffEmail;
    }

    public String getStaffPhone() {
        return staffPhone;
    }

    public StaffAddress getStaffAddress(){ return staffAddress; }

    public StaffBank getStaffBank(){ return staffBank; }

    public Set<Employment> getEmployments() {
        return employments;
    }

    //SETTER METHODS
    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public void setStaffFN(String staffFN) {
        this.staffFN= staffFN;
    }

    public void setStaffLN(String staffLN) {
        this.staffLN = staffLN;
    }

    public void setStaffDOB(LocalDate staffDOB) {
        this.staffDOB = staffDOB;
    }

    public void setStaffEmail(String staffEmail) {
        this.staffEmail = staffEmail;
    }

    public void setStaffPhone(String staffPhone) {
        this.staffPhone = staffPhone;
    }

    public void setStaffAddress(StaffAddress staffAddress) { this.staffAddress = staffAddress; }

    public void setStaffBank(StaffBank staffBank) { this.staffBank = staffBank; }

    public void setEmployments(Set<Employment> employments) {
        this.employments = employments;
    }

}