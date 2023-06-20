package com.myscaler.parkinglot.Strategies.SpotAssignmentStrategies;

import java.util.Optional;

import com.myscaler.parkinglot.Models.Gate;
import com.myscaler.parkinglot.Models.ParkingLot;
import com.myscaler.parkinglot.Models.ParkingSpot;
import com.myscaler.parkinglot.Models.VehicalType;

public interface SpotAssignmentStrategies {

    Optional<ParkingSpot> findSpot(VehicalType vehicalType, ParkingLot parkingLot, Gate gate);
}
