package com.GymManagement.DTO.Payment.Types;

import com.GymManagement.DTO.Payment.Payment;
import jakarta.persistence.*;

@Entity
@Table(name = "cash")
public class Cash {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cash_id", nullable = false)
    private Integer cashId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "payment_id", nullable = false)
    private Payment payment;

    @Column(name = "given_cash", length = 45)
    private String givenCash;

    @Column(name = "returned_cash", length = 45)
    private String returnedCash;

    //GETTER METHODS
    public Integer getCashId() {
        return cashId;
    }

    public Payment getPayment() {
        return payment;
    }

    public String getGivenCash() {
        return givenCash;
    }

    public String getReturnedCash() {
        return returnedCash;
    }

    //SETTER METHODS
    public void setCashId(Integer cashId) {
        this.cashId = cashId;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public void setGivenCash(String givenCash) {
        this.givenCash = givenCash;
    }

    public void setReturnedCash(String returnedCash) {
        this.returnedCash = returnedCash;
    }

}