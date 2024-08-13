package com.GymManagement.DTO.Payment.Types;

import com.GymManagement.DTO.Payment.Payment;
import jakarta.persistence.*;

@Entity
@Table(name = "credit_cards")
public class CreditCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cc_id", nullable = false)
    private Integer ccId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "payment_id", nullable = false)
    private Payment payment;

    @Column(name = "cc_name")
    private String ccName;

    @Column(name = "cc_number")
    private String ccNumber;

    @Column(name = "cc_expiration", length = 10)
    private String ccExpiration;

    @Column(name = "cc_ccv", length = 10)
    private String ccCcv;

    //GETTER METHODS
    public Integer getCcId() {
        return ccId;
    }

    public Payment getPayment() {
        return payment;
    }

    public String getCcName() {
        return ccName;
    }

    public String getCcNumber() {
        return ccNumber;
    }

    public String getCcExpiration() {
        return ccExpiration;
    }

    public String getCcCcv() {
        return ccCcv;
    }

    //SETTER METHODS
    public void setCcId(Integer ccId) {
        this.ccId = ccId;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public void setCcName(String ccName) {
        this.ccName = ccName;
    }

    public void setCcNumber(String ccNumber) {
        this.ccNumber = ccNumber;
    }

    public void setCcExpiration(String ccExpiration) {
        this.ccExpiration = ccExpiration;
    }

    public void setCcCcv(String ccCcv) {
        this.ccCcv = ccCcv;
    }

}