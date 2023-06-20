package com.myscaler.parkinglot.Repository;

import java.util.Map;
import java.util.TreeMap;

import com.myscaler.parkinglot.Models.Ticket;

public class TicketRepository {
    private Map<Long, Ticket> tickets = new TreeMap<>();
    private long lastSavedID = 0L;

    public Ticket save(Ticket ticket) {

        ticket.setId(lastSavedID + 1);
        lastSavedID = +1;
        tickets.put(lastSavedID, ticket);

        return ticket;
    }

}
