package com.GymManagement.DTO;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "membership")
public class Membership {

    //ATTRIBUTE MAPPING
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "membership_id", nullable = false)
    private Integer membershipId;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "membership_id", nullable = false)
    private Member member;

    @Enumerated(EnumType.STRING)
    @Column(name = "member_type", length = 25)
    private MembershipType memberType;

    @Column(name = "membership_details", length = 1024)
    private String membershipDetails;

    @Column(name = "price", precision = 10, scale = 2)
    private BigDecimal price;

    @Column(name = "duration")
    private String duration;

    @OneToMany(mappedBy = "membership")
    private Set<MemberMembership> memberMemberships = new LinkedHashSet<>();

    public Integer getMembershipId() {
        return membershipId;
    }

    public Member getMember() {
        return member;
    }

    public MembershipType getMemberType() {
        return memberType;
    }

    public String getMembershipDetails() {
        return membershipDetails;
    }

    public String getDuration() {
        return duration;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Set<MemberMembership> getMemberMemberships() {
        return memberMemberships;
    }

    //SETTER METHODS
    public void setMember(Member member) {
        this.member = member;
    }

    public void setMembershipId(Integer membershipId) {
        this.membershipId = membershipId;
    }

    public void setMemberType(MembershipType memberType) {
        this.memberType = memberType;
    }

    public void setMembershipDetails(String membershipDetails) {
        this.membershipDetails = membershipDetails;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setMemberMemberships(Set<MemberMembership> memberMemberships) {
        this.memberMemberships = memberMemberships;
    }

}