package com.GymManagement.DTO.Payment.Types;

import com.GymManagement.DTO.Payment.Payment;
import jakarta.persistence.*;

@Entity
@Table(name = "debit_cards")
public class DebitCard {

    //CONSTRUCTOR
    public DebitCard(Integer dcId,Payment payment,String dcName,
                     String dcNumber,String dcExpiration,String dcCvv,String dcPin){

        this.dcId = dcId;
        this.payment = payment;
        this.dcName = dcName;
        this.dcNumber = dcNumber;
        this.dcExpiration = dcExpiration;
        this.dcCvv = dcCvv;
        this.dcPin= dcPin;

    }

    //EMPTY CONSTRUCTOR
    public DebitCard(){}

    //ATTRIBUTE MAPPING
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dc_id", nullable = false)
    private Integer dcId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "payment_id", nullable = false)
    private Payment payment;

    @Column(name = "dc_name")
    private String dcName;

    @Column(name = "dc_number")
    private String dcNumber;

    @Column(name = "dc_expiration", length = 10)
    private String dcExpiration;

    @Column(name = "dc_cvv", length = 10)
    private String dcCvv;

    @Column(name = "dc_pin", length = 10)
    private String dcPin;

    //GETTER METHODS
    public Integer getDcId() {
        return dcId;
    }

    public Payment getPayment() {
        return payment;
    }

    public String getDcName() {
        return dcName;
    }

    public String getDcNumber() {
        return dcNumber;
    }

    public String getDcExpiration() {
        return dcExpiration;
    }

    public String getDcCvv() {
        return dcCvv;
    }

    public String getDcPin() {
        return dcPin;
    }

    //SETTER METHODS
    public void setDcId(Integer dcId) {
        this.dcId = dcId;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public void setDcName(String dcName) {
        this.dcName = dcName;
    }

    public void setDcNumber(String dcNumber) {
        this.dcNumber = dcNumber;
    }

    public void setDcExpiration(String dcExpiration) {
        this.dcExpiration = dcExpiration;
    }

    public void setDcCvv(String dcCvv) {
        this.dcCvv = dcCvv;
    }

    public void setDcPin(String dcPin) {
        this.dcPin = dcPin;
    }

}