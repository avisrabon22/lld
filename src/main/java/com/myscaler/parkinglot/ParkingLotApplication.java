package com.myscaler.parkinglot;

import com.myscaler.parkinglot.Controllers.TicketController;
import com.myscaler.parkinglot.Repository.GateRepository;
import com.myscaler.parkinglot.Repository.ParkingLotRepository;
import com.myscaler.parkinglot.Repository.TicketRepository;
import com.myscaler.parkinglot.Repository.VehicalRepository;
import com.myscaler.parkinglot.Services.TicketService;
import com.myscaler.parkinglot.Strategies.SpotAssignmentStrategies.RandomSpotAssignmentStratergies;
import com.myscaler.parkinglot.Strategies.SpotAssignmentStrategies.SpotAssignmentStrategies;

public class ParkingLotApplication {
    public static void main(String[] args) {

        GateRepository gateRepository = new GateRepository();
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
        TicketRepository ticketRepository = new TicketRepository();
        VehicalRepository vehicalRepository = new VehicalRepository();
        SpotAssignmentStrategies spotAssignmentStrategies = new RandomSpotAssignmentStratergies();

        TicketService ticketService = new TicketService(
                gateRepository,
                vehicalRepository,
                spotAssignmentStrategies,
                ticketRepository,
                parkingLotRepository);

        TicketController ticketController = new TicketController(ticketService);
        System.out.println("Server started...");
    }

}
