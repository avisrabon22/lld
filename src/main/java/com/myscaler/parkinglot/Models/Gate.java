package com.myscaler.parkinglot.Models;

public class Gate extends Base_Model {
    private int gateNo;
    private Operator currenOperator;
    private GateStatus gateStatus;
    private GateType gateType;

    public int getGateNo() {
        return gateNo;
    }

    public void setGateNo(int gateNo) {
        this.gateNo = gateNo;
    }

    public GateStatus getGateStatus() {
        return gateStatus;
    }

    public void setGateStatus(GateStatus gateStatus) {
        this.gateStatus = gateStatus;
    }

    public GateType getGateType() {
        return gateType;
    }

    public void setGateType(GateType gateType) {
        this.gateType = gateType;
    }

    public Operator getCurrenOperator() {
        return currenOperator;
    }

    public void setCurrenOperator(Operator currenOperator) {
        this.currenOperator = currenOperator;
    }

}
