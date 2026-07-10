package com.yukta.systemdesign.lld.interview_problems.parking_lot.interview.strategy.parking;

import com.yukta.systemdesign.lld.interview_problems.parking_lot.interview.domain.ParkingSlot;
import com.yukta.systemdesign.lld.interview_problems.parking_lot.interview.domain.Vehicle;

import java.util.Comparator;
import java.util.List;

public class VIPParkingStrategy implements ParkingStrategy {

    @Override
    public ParkingSlot findSlot(List<ParkingSlot> parkingSlots,
                                Vehicle vehicle) {

        // First preference: VIP Slot
        ParkingSlot vipSlot = parkingSlots.stream()
                .filter(ParkingSlot::isAvailable)
                .filter(slot -> slot.canPark(vehicle))
                .filter(ParkingSlot::isVipSlot)
                .min(Comparator.comparingInt(ParkingSlot::getDistanceFromGate))
                .orElse(null);

        if (vipSlot != null) {
            return vipSlot;
        }

        // Second preference: Normal Slot
        return parkingSlots.stream()
                .filter(ParkingSlot::isAvailable)
                .filter(slot -> slot.canPark(vehicle))
                .min(Comparator.comparingInt(ParkingSlot::getDistanceFromGate))
                .orElse(null);
    }
}
