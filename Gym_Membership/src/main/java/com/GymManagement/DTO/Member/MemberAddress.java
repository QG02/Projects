package com.GymManagement.DTO.Member;

import jakarta.persistence.*;

//Address class created as an abstraction for the member object class.
//Parses the address information from the member's table from the database
//as a separate object, which is passed to the member object when created.
@Embeddable
public class MemberAddress {

    //ATTRIBUTE MAPPING
    @Column(name = "member_address")
    private String memberAddress;

    @Column(name = "member_city")
    private String memberCity;

    @Column(name = "member_state")
    private String memberState;

    @Column(name = "member_zip")
    private String memberZip;

    //GETTER METHODS
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

    //SETTER METHODS
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

}
