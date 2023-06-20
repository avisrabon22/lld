package com.myscaler.parkinglot.Repository;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

import com.myscaler.parkinglot.Models.Gate;
import com.myscaler.parkinglot.Models.ParkingLot;

public class ParkingLotRepository {

    private Map<Long, ParkingLot> parkingLots = new TreeMap<>();

    public Optional<ParkingLot> getParkingLotOFGate(Gate gate) {

        for (ParkingLot parkingLot : parkingLots.values()) {
            if (parkingLot.getGates().contains(gate))
                ;
            return Optional.of(parkingLot);
        }
        return Optional.empty();

    }
}
