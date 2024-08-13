package com.GymManagement.DTO;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "payment")
public class Payment {

    //ATTRIBUTE MAPPING
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id", nullable = false)
    private Integer paymentId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @Column(name = "amount", precision = 10, scale = 2)
    private BigDecimal amount;

    @Column(name = "date_time")
    private Instant dateTime;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_type", length = 25)
    private PaymentType paymentType;

    //GETTER METHODS
    public Integer getPaymentId() {
        return paymentId;
    }

    public Member getMember() {
        return member;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public Instant getDateTime() {
        return dateTime;
    }

    //SETTER METHODS
    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setDateTime(Instant dateTime) {
        this.dateTime = dateTime;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

}