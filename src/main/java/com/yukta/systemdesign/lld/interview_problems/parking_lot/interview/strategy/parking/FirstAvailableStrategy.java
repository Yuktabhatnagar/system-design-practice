package com.yukta.systemdesign.lld.interview_problems.parking_lot.interview.strategy.parking;

import com.yukta.systemdesign.lld.interview_problems.parking_lot.interview.domain.ParkingSlot;
import com.yukta.systemdesign.lld.interview_problems.parking_lot.interview.domain.Vehicle;

import java.util.List;

public class FirstAvailableStrategy implements ParkingStrategy {

    @Override
    public ParkingSlot findSlot(List<ParkingSlot> parkingSlots,
                                Vehicle vehicle) {
        return parkingSlots.stream()
                .filter(ParkingSlot::isAvailable)
                .filter(slot -> slot.canPark(vehicle))
                .findFirst()
                .orElse(null);
    }
}
