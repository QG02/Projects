package com.GymManagement.DTO.Member;

import com.GymManagement.DTO.Session.Enrollment;
import com.GymManagement.DTO.MemberShip.MemberMembership;
import com.GymManagement.DTO.Payment.Payment;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "member")
public class Member {

    //CONSTRUCTOR
    public Member(Integer memberId, String memberFN, String memberLN,
                  LocalDate memberDOB, String memberEmail, String memberPhone,
                  MemberAddress memberAddress, MemberBank memberBank){

        this.memberId = memberId;
        this.memberFN = memberFN;
        this.memberLN = memberLN;
        this.memberDOB = memberDOB;
        this.memberEmail = memberEmail;
        this.memberPhone = memberPhone;
        this.memberAddress = memberAddress;
        this.memberBank = memberBank;
        this.enrollments = new LinkedHashSet<>();
        this.memberMemberships = new LinkedHashSet<>();
        this.payments = new LinkedHashSet<>();

    }

    //EMPTY CONSTRUCTOR - HIBERNATE REQUIREMENT
    public Member(){}

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

    @Embedded
    private MemberAddress memberAddress;

    @Embedded
    private MemberBank memberBank;

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

    public MemberBank getMemberBank(){
        return memberBank;
    }

    public MemberAddress getMemberAddress(){
        return memberAddress;
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

    public void setMemberBank(MemberBank memberBank){
        this.memberBank = memberBank;
    }

    public void setMemberAddress(MemberAddress memberAddress){
        this.memberAddress = memberAddress;
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