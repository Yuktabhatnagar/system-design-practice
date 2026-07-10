package com.yukta.systemdesign.lld.interview_problems.parking_lot.interview.service;

//Generate Ticket
//Close Ticket
//Fetch Ticket

import com.yukta.systemdesign.lld.interview_problems.parking_lot.interview.domain.ParkingSlot;
import com.yukta.systemdesign.lld.interview_problems.parking_lot.interview.domain.Ticket;
import com.yukta.systemdesign.lld.interview_problems.parking_lot.interview.domain.Vehicle;

import java.time.LocalDateTime;

public class TicketService {

    public Ticket generateTicket(Vehicle vehicleParked, ParkingSlot slot) {
        return new Ticket(
                vehicleParked,
                slot,
                LocalDateTime.now()
        );
    }

    public void closeTicket(Ticket ticket) {
        ticket.setExitTime(LocalDateTime.now());
    }

    //later introduce TicketRepository
    public Ticket fetchTicket(Ticket ticket) {
        return ticket;
    }
}
