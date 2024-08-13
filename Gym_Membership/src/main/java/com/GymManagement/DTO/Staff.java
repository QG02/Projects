package com.GymManagement.DTO;

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

    @Column(name = "staff_address")
    private String staffAddress;

    @Column(name = "staff_city")
    private String staffCity;

    @Column(name = "staff_state")
    private String staffState;

    @Column(name = "staff_zip")
    private String staffZip;

    @Column(name = "staff_bank")
    private String staffBank;

    @Column(name = "staff_routing")
    private String staffRouting;

    @Column(name = "staff_account", length = 25)
    private String staffAccount;

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

    public String getStaffAddress() {
        return staffAddress;
    }

    public String getStaffCity() {
        return staffCity;
    }

    public String getStaffState() {
        return staffState;
    }

    public String getStaffZip() {
        return staffZip;
    }

    public String getStaffBank() {
        return staffBank;
    }

    public String getStaffRouting() {
        return staffRouting;
    }

    public String getStaffAccount() {
        return staffAccount;
    }

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

    public void setStaffAddress(String staffAddress) {
        this.staffAddress = staffAddress;
    }

    public void setStaffCity(String staffCity) {
        this.staffCity = staffCity;
    }

    public void setStaffState(String staffState) {
        this.staffState = staffState;
    }

    public void setStaffZip(String staffZip) {
        this.staffZip = staffZip;
    }

    public void setStaffBank(String staffBank) {
        this.staffBank = staffBank;
    }

    public void setStaffRouting(String staffRouting) {
        this.staffRouting = staffRouting;
    }

    public void setStaffAccount(String staffAccount) {
        this.staffAccount = staffAccount;
    }

    public void setEmployments(Set<Employment> employments) {
        this.employments = employments;
    }

}