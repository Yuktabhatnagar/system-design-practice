package com.yukta.systemdesign.lld.interview_problems.parking_lot.interview.domain;

import com.yukta.systemdesign.lld.interview_problems.parking_lot.interview.enums.SlotStatus;
import com.yukta.systemdesign.lld.interview_problems.parking_lot.interview.enums.VehicleType;

import java.util.UUID;

public class ParkingSlot {
    //    VehicleType, slotId, IsOccupied, VehicleId, Floor,
    private final UUID slotId;   //PK
    private final VehicleType supportedType;
    private Vehicle parkedVehicle;  //FK      Objects should reference other objects, not IDs.  IDs are primarily for databases.
    private ParkingFloor parkingFloor;
    private SlotStatus status;
    private boolean vipSlot;

    public boolean isVipSlot() {
        return vipSlot;
    }

    public int getDistanceFromGate() {
        return distanceFromGate;
    }

    private int distanceFromGate;

    public ParkingSlot(VehicleType vehicleType, ParkingFloor parkingFloor) {
        this.slotId = UUID.randomUUID();
        this.supportedType = vehicleType;
        this.parkingFloor = parkingFloor;
        this.status = SlotStatus.AVAILABLE;
    }

    public UUID getSlotId() {
        return slotId;
    }

    public Vehicle getParkedVehicle() {
        return parkedVehicle;
    }

    public ParkingFloor getParkingFloor() {
        return parkingFloor;
    }
//responsibilities:   Park Vehicle, Release Vehicle, Report Availability, Validate compatible vehicle

    public boolean isAvailable() {
        return status == SlotStatus.AVAILABLE;
    }

    public boolean canPark(Vehicle vehicle) {
        return vehicle.getVehicleType() == supportedType;
    }

    public synchronized void parkVehicle(Vehicle vehicle) {
        if (!canPark(vehicle)) {
            throw new IllegalArgumentException(
                    "Invalid Vehicle Type"
            );
        }
        parkedVehicle = vehicle;
        status = SlotStatus.OCCUPIED;
    }

    public synchronized void releaseVehicle() {
        parkedVehicle = null;
        status = SlotStatus.AVAILABLE;
    }
//SOLID- SRP. OCP: ParkingSlot-> ElectricParkingSlot , LSP: TruckSlot,CarSlot,BikeSlot can replace ParkingSlot, DIP: ParkingSlot depends on Vehicle, not on Car.

}
