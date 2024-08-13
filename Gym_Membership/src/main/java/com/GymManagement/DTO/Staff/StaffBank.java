package com.GymManagement.DTO.Staff;

import jakarta.persistence.*;

//StaffBank class created as an abstraction for the staff object class.
//Parses the bank information from the staff's table from the database
//as a separate object, which is passed to the staff object when created.
@Embeddable
public class StaffBank {

    //ATTRIBUTE MAPPING
    @Column(name = "staff_bank")
    private String staffBank;

    @Column(name = "staff_routing")
    private String staffRouting;

    @Column(name = "staff_account", length = 25)
    private String staffAccount;

    //GETTER METHODS
    public String getStaffBank() {
        return staffBank;
    }

    public String getStaffRouting() {
        return staffRouting;
    }

    public String getStaffAccount() {
        return staffAccount;
    }

    //SETTER METHODS
    public void setStaffBank(String staffBank) {
        this.staffBank = staffBank;
    }

    public void setStaffRouting(String staffRouting) {
        this.staffRouting = staffRouting;
    }

    public void setStaffAccount(String staffAccount) {
        this.staffAccount = staffAccount;
    }

}
