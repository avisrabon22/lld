package com.myscaler.parkinglot.Repository;

import java.util.Optional;

import com.myscaler.parkinglot.Models.Gate;

public interface IGateRepository {
    Optional<Gate> findGateId(Long gateID);

}
