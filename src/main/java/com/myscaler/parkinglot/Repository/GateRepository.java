package com.myscaler.parkinglot.Repository;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

import com.myscaler.parkinglot.Models.Gate;

public class GateRepository implements IGateRepository {

    private Map<Long, Gate> gates = new TreeMap<>();

    public Optional<Gate> findGateId(Long gateID) {

        if (gates.containsKey(gateID)) {
            return Optional.of(gates.get(gateID));
        }

        return Optional.empty();
    }
}
