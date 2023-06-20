package com.myscaler.parkinglot.Services;

import java.util.Date;
import java.util.Optional;

import com.myscaler.parkinglot.Models.Gate;
import com.myscaler.parkinglot.Models.Operator;
import com.myscaler.parkinglot.Models.ParkingLot;
import com.myscaler.parkinglot.Models.ParkingSpot;
import com.myscaler.parkinglot.Models.Ticket;
import com.myscaler.parkinglot.Models.Vehical;
import com.myscaler.parkinglot.Models.VehicalType;
import com.myscaler.parkinglot.Repository.IGateRepository;
import com.myscaler.parkinglot.Repository.ParkingLotRepository;
import com.myscaler.parkinglot.Repository.TicketRepository;
import com.myscaler.parkinglot.Repository.VehicalRepository;
import com.myscaler.parkinglot.Strategies.SpotAssignmentStrategies.SpotAssignmentStrategies;
import com.myscaler.parkinglot.throwException.invalidException;
import com.myscaler.parkinglot.throwException.invalidGateException;
import com.myscaler.parkinglot.throwException.invalidParkingSpot;
import com.myscaler.parkinglot.throwException.noAvailableSpotException;

public class TicketService {
    private IGateRepository gateRepository;
    private VehicalRepository vehicalRepository;
    private SpotAssignmentStrategies spotAssignmentStrategies;
    private TicketRepository ticketRepository;
    private ParkingLotRepository parkingLotRepository;

    public TicketService(IGateRepository gateRepository, VehicalRepository vehicalRepository,
            SpotAssignmentStrategies spotAssignmentStrategies, TicketRepository ticketRepository,
            ParkingLotRepository parkingLotRepository) {
        this.gateRepository = gateRepository;
        this.vehicalRepository = vehicalRepository;
        this.spotAssignmentStrategies = spotAssignmentStrategies;
        this.ticketRepository = ticketRepository;
        this.parkingLotRepository = parkingLotRepository;

    }

    public Ticket generateTicket(Long getId, VehicalType vehicalType, String vehicalNumber)
            throws invalidException, noAvailableSpotException, invalidGateException, invalidParkingSpot {

        Optional<Gate> gateOptional = gateRepository.findGateId(getId);

        if (gateOptional.isEmpty()) {
            throw new invalidException();

        }

        Gate gate = gateOptional.get();

        Operator operator = gate.getCurrenOperator();

        Optional<Vehical> vehicalOptional = vehicalRepository.findVehicalByNumber(vehicalNumber);

        Vehical vehical;

        if (vehicalOptional.isEmpty()) {
            vehical = new Vehical();
            vehical.setVehicalNo(vehicalNumber);
            vehical.setVehicalType(vehicalType);
            vehical = vehicalRepository.save(vehical);
        } else {
            vehical = vehicalOptional.get();
        }

        Optional<ParkingLot> parkingLot = parkingLotRepository.getParkingLotOFGate(gate);

        if (parkingLot.isEmpty()) {
            throw new RuntimeException();
        }

        Optional<ParkingSpot> parkingSpotOptional = spotAssignmentStrategies.findSpot(vehicalType, parkingLot.get(),
                gate);

        if (parkingSpotOptional.isEmpty()) {
            throw new invalidParkingSpot();
        }

        ParkingSpot parkingSpot = parkingSpotOptional.get();
        Ticket ticket = new Ticket();
        ticket.setParkingSpot(parkingSpot);
        ticket.setEntryTime(new Date());
        ticket.setVehical(vehical);
        ticket.setGate(gate);
        ticket.setOperator(operator);

        return ticketRepository.save(ticket);
    }

}
