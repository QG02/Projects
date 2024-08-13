package com.GymManagement.DTO;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "member")
public class Member {

    //ATTRIBUTE MAPPING
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id", nullable = false)
    private Integer memberId;

    @Column(name = "first_name")
    private String memberFN;

    @Column(name = "last_name")
    private String memberLN;

    @Column(name = "date_of_birth")
    private LocalDate memberDOB;

    @Column(name = "email")
    private String memberEmail;

    @Column(name = "phone", length = 20)
    private String memberPhone;

    @Column(name = "member_address")
    private String memberAddress;

    @Column(name = "member_city")
    private String memberCity;

    @Column(name = "member_state")
    private String memberState;

    @Column(name = "member_zip")
    private String memberZip;

    @Column(name = "member_bank")
    private String memberBank;

    @Column(name = "member_routing", length = 25)
    private String memberRouting;

    @Column(name = "member_account", length = 25)
    private String memberAccount;

    @OneToMany(mappedBy = "member")
    private Set<Enrollment> enrollments = new LinkedHashSet<>();

    @OneToMany(mappedBy = "member")
    private Set<MemberMembership> memberMemberships = new LinkedHashSet<>();

    @OneToMany(mappedBy = "member")
    private Set<Payment> payments = new LinkedHashSet<>();

    //GETTER METHODS
    public Integer getMemberId() {
        return memberId;
    }

    public String getMemberFN() {
        return memberFN;
    }

    public String getMemberLN() {
        return memberLN;
    }

    public LocalDate getMemberDOB() {
        return memberDOB;
    }

    public String getMemberEmail() {
        return memberEmail;
    }

    public String getMemberPhone() {
        return memberPhone;
    }

    public String getMemberAddress() {
        return memberAddress;
    }

    public String getMemberCity() {
        return memberCity;
    }

    public String getMemberState() {
        return memberState;
    }

    public String getMemberZip() {
        return memberZip;
    }

    public String getMemberBank() {
        return memberBank;
    }

    public String getMemberRouting() {
        return memberRouting;
    }

    public String getMemberAccount() {
        return memberAccount;
    }

    public Set<Enrollment> getEnrollments() {
        return enrollments;
    }

    public Set<MemberMembership> getMemberMemberships() {
        return memberMemberships;
    }

    public Set<Payment> getPayments() {
        return payments;
    }

    //SETTER METHODS
    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public void setMemberFN(String memberFN) {
        this.memberFN = memberFN;
    }

    public void setMemberLN(String memberLN) {
        this.memberLN = memberLN;
    }

    public void setMemberDOB(LocalDate memberDOB) {
        this.memberDOB = memberDOB;
    }

    public void setMemberEmail(String memberEmail) {
        this.memberEmail = memberEmail;
    }

    public void setMemberPhone(String memberPhone) {
        this.memberPhone = memberPhone;
    }

    public void setMemberAddress(String memberAddress) {
        this.memberAddress = memberAddress;
    }

    public void setMemberCity(String memberCity) {
        this.memberCity = memberCity;
    }

    public void setMemberState(String memberState) {
        this.memberState = memberState;
    }

    public void setMemberZip(String memberZip) {
        this.memberZip = memberZip;
    }

    public void setMemberBank(String memberBank) {
        this.memberBank = memberBank;
    }

    public void setMemberRouting(String memberRouting) {
        this.memberRouting = memberRouting;
    }

    public void setMemberAccount(String memberAccount) {
        this.memberAccount = memberAccount;
    }

    public void setEnrollments(Set<Enrollment> enrollments) {
        this.enrollments = enrollments;
    }

    public void setMemberMemberships(Set<MemberMembership> memberMemberships) {
        this.memberMemberships = memberMemberships;
    }

    public void setPayments(Set<Payment> payments) {
        this.payments = payments;
    }

}