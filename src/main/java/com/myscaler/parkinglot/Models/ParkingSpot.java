package com.myscaler.parkinglot.Models;

import java.util.List;

public class ParkingSpot extends Base_Model {
    private int number;
    private List<VehicalType> vehicalTypes;
    private SpotStatus spotStatus;
    private Vehical vehical;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public List<VehicalType> getVehicalTypes() {
        return vehicalTypes;
    }

    public void setVehicalTypes(List<VehicalType> vehicalTypes) {
        this.vehicalTypes = vehicalTypes;
    }

    public SpotStatus getSpotStatus() {
        return spotStatus;
    }

    public void setSpotStatus(SpotStatus spotStatus) {
        this.spotStatus = spotStatus;
    }

    public Vehical getVehical() {
        return vehical;
    }

    public void setVehical(Vehical vehical) {
        this.vehical = vehical;
    }

}
