package com.GymManagement.DTO.Payment;

public enum PaymentType {

    CASH("cash"),
    DEBIT("debit"),
    CREDIT("credit");

    private final String value;

    PaymentType(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }

    public static PaymentType fromValue(String value){
        for(PaymentType type: PaymentType.values()){
            if(type.value.equalsIgnoreCase(value)){
                return type;
            }
        }
        throw new IllegalArgumentException("UNKNOWN VALUE" + value);
    }

}

