package com.GymManagement.DTO.Staff;

import jakarta.persistence.*;

//StaffAddress class created as an abstraction for the staff object class.
//Parses the address information from the staff's table from the database
//as a separate object, which is passed to the staff object when created.
@Embeddable
public class StaffAddress {

    //ATTRIBUTE MAPPING
    @Column(name = "staff_address")
    private String staffAddress;

    @Column(name = "staff_city")
    private String staffCity;

    @Column(name = "staff_state")
    private String staffState;

    @Column(name = "staff_zip")
    private String staffZip;

    //GETTER METHODS
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

    //SETTER METHODS
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


}
