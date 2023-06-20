package com.myscaler.parkinglot.DTOs;

import com.myscaler.parkinglot.Models.VehicalType;

public class GanrateTicketRequestDTO {

    private String VehicaleNumber;
    private VehicalType vehicalType;
    private Long gateId;

    public String getVehicaleNumber() {
        return VehicaleNumber;
    }

    public void setVehicaleNumber(String vehicaleNumber) {
        VehicaleNumber = vehicaleNumber;
    }

    public VehicalType getVehicalType() {
        return vehicalType;
    }

    public void setVehicalType(VehicalType vehicalType) {
        this.vehicalType = vehicalType;
    }

    public Long getGetId() {
        return gateId;
    }

    public void setGetId(Long gateId) {
        this.gateId = gateId;
    }

}
