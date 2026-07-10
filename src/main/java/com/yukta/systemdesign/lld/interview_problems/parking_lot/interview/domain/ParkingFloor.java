package com.yukta.systemdesign.lld.interview_problems.parking_lot.interview.domain;

import com.yukta.systemdesign.lld.interview_problems.parking_lot.interview.exception.SlotOccupiedException;
import com.yukta.systemdesign.lld.interview_problems.parking_lot.interview.strategy.parking.ParkingStrategy;

import java.util.*;

public class ParkingFloor {
    private final int floorNumber;
    private final List<ParkingSlot> parkingSlots;
    private final ParkingStrategy strategy;


    public ParkingFloor(int floorNumber, ParkingStrategy strategy) {
        this.floorNumber = floorNumber;
        this.strategy = strategy;
        this.parkingSlots = new ArrayList<>();
    }

    // Admin Operations
    public void addSlot(ParkingSlot slot) {
        parkingSlots.add(slot);
    }

    public void removeSlot(ParkingSlot slot) throws SlotOccupiedException {
        if(slot.isAvailable()){
            parkingSlots.remove(slot);
        }else throw new SlotOccupiedException("No available slot");
    }

    // Parking Operations

    public synchronized ParkingSlot allocateSlot(Vehicle vehicle) {
        ParkingSlot slot =
                strategy.findSlot(parkingSlots, vehicle);
        if (slot == null) {
            return null;
        }
        slot.parkVehicle(vehicle);
        return slot;
    }

    public void releaseSlot(ParkingSlot slot) {
        slot.releaseVehicle();
    }

    // Query Operations
    public List<ParkingSlot> getParkingSlots() {
        return parkingSlots;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    //  Suppose 1000 slots, Every time-> getAvailableSlots(),  loops through all slots. O(n)
    public List<ParkingSlot> getAvailableSlots() {
        List<ParkingSlot> availableSlot = new ArrayList<>();
        for (ParkingSlot slot : parkingSlots) {
            if (slot.isAvailable()) {
                availableSlot.add(slot);
            }
        }
        return availableSlot;
    }


    //I'd maintain an AtomicInteger availableSlotCount
    public int getAvailableSlotCount() {
        return getAvailableSlots().size();
    }

    private ParkingSlot findAvailableSlot(Vehicle vehicle){
        return strategy.findSlot(parkingSlots, vehicle);
    }
}
