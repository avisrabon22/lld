package com.myscaler.parkinglot.Models;

import java.util.List;

public class ParkingLot extends Base_Model {
    private List<ParkingFloor> parkingFloors;
    private List<Gate> Gates;
    private int Capacity;

    public List<ParkingFloor> getParkingFloors() {
        return parkingFloors;
    }

    public void setParkingFloors(List<ParkingFloor> parkingFloors) {
        this.parkingFloors = parkingFloors;
    }

    public List<Gate> getGates() {
        return Gates;
    }

    public void setGates(List<Gate> gates) {
        Gates = gates;
    }

    public int getCapacity() {
        return Capacity;
    }

    public void setCapacity(int capacity) {
        Capacity = capacity;
    }

}
