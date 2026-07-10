package com.yukta.systemdesign.lld.interview_problems.parking_lot.interview.strategy.parking;

import com.yukta.systemdesign.lld.interview_problems.parking_lot.interview.domain.ParkingSlot;
import com.yukta.systemdesign.lld.interview_problems.parking_lot.interview.domain.Vehicle;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class RandomStrategy implements ParkingStrategy {

    @Override
    public ParkingSlot findSlot(List<ParkingSlot> parkingSlots,
                                Vehicle vehicle) {
        List<ParkingSlot>parkingSlotList=  parkingSlots.stream()
                .filter(ParkingSlot::isAvailable)
                .filter(slot -> slot.canPark(vehicle))
                .toList();

        if (parkingSlotList.isEmpty()) {
            return null;
        }
        int index= ThreadLocalRandom.current().nextInt(parkingSlotList.size());
        return parkingSlotList.get(index);
    }
}
