package com.myscaler.parkinglot.Strategies.SpotAssignmentStrategies;

import java.util.Optional;

import com.myscaler.parkinglot.Models.Gate;
import com.myscaler.parkinglot.Models.ParkingFloor;
import com.myscaler.parkinglot.Models.ParkingLot;
import com.myscaler.parkinglot.Models.ParkingSpot;
import com.myscaler.parkinglot.Models.SpotStatus;
import com.myscaler.parkinglot.Models.VehicalType;

public class RandomSpotAssignmentStratergies implements SpotAssignmentStrategies {

    @Override
    public Optional<ParkingSpot> findSpot(VehicalType vehicalType, ParkingLot parkinglot, Gate entryGate) {
        // TODO Auto-generated method stub
        for (ParkingFloor parkFloor : parkinglot.getParkingFloors()) {
            for (ParkingSpot parkingSpot : parkFloor.getParkingSpots()) {

                if (parkingSpot.getSpotStatus().equals(SpotStatus.AVAILABLE)
                        && parkingSpot.getVehicalTypes().contains(vehicalType)) {

                    return Optional.of(parkingSpot);
                }
            }
        }
        return Optional.empty();
    }

}
