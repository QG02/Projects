package com.GymManagement.DTO.Member;

import jakarta.persistence.*;

//MemberBank class created as an abstraction for the member object class.
//Parses the bank information from the member's table from the database
//as a separate object, which is passed to the member object when created.
@Embeddable
public class MemberBank {

    //ATTRIBUTE MAPPING
    @Column(name = "member_bank")
    private String memberBank;

    @Column(name = "member_routing", length = 25)
    private String memberRouting;

    @Column(name = "member_account", length = 25)
    private String memberAccount;

    //GETTER METHODS
    public String getMemberBank() {
        return memberBank;
    }

    public String getMemberRouting() {
        return memberRouting;
    }

    public String getMemberAccount() {
        return memberAccount;
    }

    //SETTER METHODS
    public void setMemberBank(String memberBank) {
        this.memberBank = memberBank;
    }

    public void setMemberRouting(String memberRouting) {
        this.memberRouting = memberRouting;
    }

    public void setMemberAccount(String memberAccount) {
        this.memberAccount = memberAccount;
    }

}
