package com.myscaler.parkinglot.Models;

import java.util.List;

public class ParkingFloor extends Base_Model {
    private List<ParkingSpot> ParkingSpots;
    private int floorNo;

    public List<ParkingSpot> getParkingSpots() {
        return ParkingSpots;
    }

    public void setParkingSpots(List<ParkingSpot> parkingSpots) {
        ParkingSpots = parkingSpots;
    }

    public int getFloorNo() {
        return floorNo;
    }

    public void setFloorNo(int floorNo) {
        this.floorNo = floorNo;
    }

}
