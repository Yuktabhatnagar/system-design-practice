package com.yukta.systemdesign.lld.interview_problems.parking_lot.interview.domain;

import com.yukta.systemdesign.lld.interview_problems.parking_lot.interview.exception.NoParkingSlotAvailableException;
import com.yukta.systemdesign.lld.interview_problems.parking_lot.interview.service.TicketService;

import java.util.List;

public class ParkingLot {
    private List<ParkingFloor> parkingFloors;
    private List<EntryGate> entryGates;
    private List<ExitGate> exitGates;
    private final TicketService ticketService;

    public ParkingLot(List<ParkingFloor> parkingFloors, List<EntryGate> entryGates, List<ExitGate> exitgates, TicketService ticketService) {
        this.parkingFloors = parkingFloors;
        this.entryGates = entryGates;
        this.exitGates = exitgates;
        this.ticketService = ticketService;
    }

    // Floor Management
    public List<ParkingFloor> getParkingFloors() {
        return parkingFloors;
    }

    public void addParkingFloor(ParkingFloor floor) {
        parkingFloors.add(floor);
    }

    public void removeParkingFloor(ParkingFloor floor) {
        parkingFloors.remove(floor);
    }

    // Parking Operations

    //    ParkingLot doesn't know how Ticket is created. It delegates to TicketService or TicketFactory.
    public Ticket parkVehicle(Vehicle vehicle) throws NoParkingSlotAvailableException {
        for (ParkingFloor floor : parkingFloors) {
            ParkingSlot slot= floor.allocateSlot(vehicle);
            if (slot != null) {
                return ticketService.generateTicket(vehicle,slot);
            }
        }
        throw new NoParkingSlotAvailableException("No Parking Slot Available");
    }


    public void unparkVehicle(Ticket ticket) {
        ParkingSlot slot = ticket.getParkingSlot();
        ParkingFloor floor = slot.getParkingFloor();
        floor.releaseSlot(slot);
    }

    //O(1)
    public void releaseSlot(ParkingSlot slot) {
        slot.getParkingFloor().releaseSlot(slot);
    }

}


