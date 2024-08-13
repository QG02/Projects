package com.GymManagement.DTO.MemberShip;

public enum MembershipType {

    REGULAR("regular"),
    DUO("duo"),
    CHILD("child"),
    SENIOR("senior"),
    STUDENT("student");

    private final String value;

    MembershipType(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }

    public MembershipType fromValue(String value){
        for(MembershipType type: MembershipType.values()){
            if(type.value.equalsIgnoreCase(value)){
                return type;
            }
        }
        throw new IllegalArgumentException("UNKNOWN VALUE" + value);
    }
}
