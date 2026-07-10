package com.yukta.systemdesign.lld.interview_problems.parking_lot.interview.domain;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
//- Record parking details(VehicleId, VehiclePlateNo, Slot )
//- Track parking session (Entry-Exit time)
//- Provide information for fee calculation

public class Ticket {
    private final UUID ticketId;
    private final Vehicle vehicle;
    private final ParkingSlot parkingSlot;
    private final LocalDateTime entryTime;

    private LocalDateTime exitTime;
    private boolean active;

    public Ticket(Vehicle vehicle, ParkingSlot parkingSlot, LocalDateTime entryTime) {
        this.ticketId = UUID.randomUUID();
        this.vehicle = vehicle;
        this.parkingSlot = parkingSlot;
        this.entryTime = entryTime;

    }

//After exit : false
    public boolean isActive() {
        return active;
    }

    public void setExitTime(LocalDateTime exitTime) {
        this.exitTime = exitTime;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ParkingSlot getParkingSlot() {
        return parkingSlot;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }
}
