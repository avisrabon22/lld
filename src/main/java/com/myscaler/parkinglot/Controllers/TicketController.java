package com.myscaler.parkinglot.Controllers;

import com.myscaler.parkinglot.DTOs.GanrateTicketRequestDTO;
import com.myscaler.parkinglot.DTOs.GanrateTicketResponseDTO;
import com.myscaler.parkinglot.DTOs.ResponseStatus;
import com.myscaler.parkinglot.Models.Ticket;
import com.myscaler.parkinglot.Models.VehicalType;
import com.myscaler.parkinglot.Services.TicketService;
import com.myscaler.parkinglot.throwException.invalidException;
import com.myscaler.parkinglot.throwException.invalidGateException;
import com.myscaler.parkinglot.throwException.invalidParkingSpot;
import com.myscaler.parkinglot.throwException.noAvailableSpotException;

public class TicketController {

    TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;

    }

    public GanrateTicketResponseDTO genrateTicket(GanrateTicketRequestDTO request)
            throws invalidException, invalidParkingSpot {
        String vehicleNumber = request.getVehicaleNumber();
        VehicalType vehicleType = request.getVehicalType();
        Long gateId = request.getGetId();

        Ticket ticket = new Ticket();

        GanrateTicketResponseDTO response = new GanrateTicketResponseDTO();

        try {
            ticket = ticketService.generateTicket(
                    gateId,
                    vehicleType,
                    vehicleNumber);
        } catch (invalidGateException e) {
            response.setResponseStatus(ResponseStatus.FAILURE);
            response.setMessage("Invalid gate id");
            return response;
        } catch (noAvailableSpotException e) {
            response.setResponseStatus(ResponseStatus.SUCCESS);
            response.setMessage("No spot available");
            return response;
        }

        response.setResponseStatus(ResponseStatus.SUCCESS);
        response.setTicketId(ticket.getId());
        response.setOperatorName(ticket.getOperator().getName());
        response.setSpotNumber(ticket.getParkingSpot().getNumber());
        return response;

    }

}