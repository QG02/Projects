package com.GymManagement.DTO;

import com.GymManagement.DTO.Member.Member;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "member_membership")
public class MemberMembership {

    //ATTRIBUTE MAPPING
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_membership_id", nullable = false)
    private Integer memberMembershipId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "membership_id")
    private Membership membership;

    @Column(name = "start_date")
    private LocalDate membershipStartDate;

    @Column(name = "end_date")
    private LocalDate membershipEndDate;

    //GETTER METHODS
    public Integer getMemberMembershipId() {
        return memberMembershipId;
    }

    public LocalDate getMembershipEndDate() {
        return membershipEndDate;
    }

    public Member getMember() {
        return member;
    }

    public Membership getMembership() {
        return membership;
    }

    public LocalDate getMembershipStartDate() {
        return membershipStartDate;
    }

    //SETTER METHODS
    public void setMemberMembershipId(Integer memberMembershipId) {
        this.memberMembershipId = memberMembershipId;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public void setMembership(Membership membership) {
        this.membership = membership;
    }

    public void setMembershipStartDate(LocalDate membershipStartDate) {
        this.membershipStartDate = membershipStartDate;
    }

    public void setMembershipEndDate(LocalDate membershipEndDate) {
        this.membershipEndDate = membershipEndDate;
    }

}