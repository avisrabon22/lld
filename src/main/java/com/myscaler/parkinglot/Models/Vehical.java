package com.myscaler.parkinglot.Models;

public class Vehical extends Base_Model {
    private String vehicalNo;
    private VehicalType vehicalType;

    public String getVehicalNo() {
        return vehicalNo;
    }

    public void setVehicalNo(String vehicalNo) {
        this.vehicalNo = vehicalNo;
    }

    public VehicalType getVehicalType() {
        return vehicalType;
    }

    public void setVehicalType(VehicalType vehicalType) {
        this.vehicalType = vehicalType;
    }

}
