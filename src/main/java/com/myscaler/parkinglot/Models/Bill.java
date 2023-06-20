package com.myscaler.parkinglot.Models;

import java.util.Date;
import java.util.List;

public class Bill extends Base_Model {
    private Date ExitTime;
    private Ticket ticket;
    private Operator operator;
    private int amount;
    private Gate gate;
    private List<Payment> payments;

    public Date getExitTime() {
        return ExitTime;
    }

    public void setExitTime(java.util.Date exitTime) {
        ExitTime = exitTime;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Gate getGate() {
        return gate;
    }

    public void setGate(Gate gate) {
        this.gate = gate;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

}
