package com.myscaler.parkinglot.Models;

import java.sql.Date;

public class Payment extends Base_Model {
    private int amount;
    private PaymentMode PaymentMode;
    private PaymentStatus PaymentStatus;
    private String refId;
    private Bill bill;
    private Date time;

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public PaymentMode getPaymentMode() {
        return PaymentMode;
    }

    public void setPaymentMode(PaymentMode paymentMode) {
        PaymentMode = paymentMode;
    }

    public PaymentStatus getPaymentStatus() {
        return PaymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        PaymentStatus = paymentStatus;
    }

    public String getRefId() {
        return refId;
    }

    public void setRefId(String refId) {
        this.refId = refId;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

}
