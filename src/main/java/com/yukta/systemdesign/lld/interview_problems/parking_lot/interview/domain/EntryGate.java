package com.yukta.systemdesign.lld.interview_problems.parking_lot.interview.domain;

import com.yukta.systemdesign.lld.interview_problems.parking_lot.interview.enums.GateStatus;
import com.yukta.systemdesign.lld.interview_problems.parking_lot.interview.exception.NoParkingSlotAvailableException;

import java.util.UUID;

//- Receive vehicle
//- Request Parking
//- Return ticket
//- Open gate
public class EntryGate {
    private final UUID id;
    private final ParkingLot parkingLot;
    private GateStatus status;

    public EntryGate(ParkingLot parkingLot, GateStatus gateStatus) {
        this.id = UUID.randomUUID();
        this.status = gateStatus;
        this.parkingLot = parkingLot;
    }

    public Ticket enterVehicle(Vehicle vehicle){
        Ticket ticket;
        try {
            ticket = parkingLot.parkVehicle(vehicle);
        } catch (Exception | NoParkingSlotAvailableException e) {
                throw new RuntimeException(e);
            }
        status = GateStatus.OPEN;
        return ticket;
    }
}
