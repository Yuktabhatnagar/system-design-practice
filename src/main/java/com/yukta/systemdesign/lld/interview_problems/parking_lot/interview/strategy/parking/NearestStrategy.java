package com.yukta.systemdesign.lld.interview_problems.parking_lot.interview.strategy.parking;

import com.yukta.systemdesign.lld.interview_problems.parking_lot.interview.domain.ParkingSlot;
import com.yukta.systemdesign.lld.interview_problems.parking_lot.interview.domain.Vehicle;

import java.util.Comparator;
import java.util.List;

//Allocate the nearest compatible parking slot to that gate. (Small parking lots)
//Option 1: Stream API,  Complexity: O(n)
//Option 2 : Priority Queue , returns the nearest slot immediately.
//peek() → O(1)
//poll() → O(log n)
//offer() → O(log n)
public class NearestStrategy implements ParkingStrategy {

    @Override
    public ParkingSlot findSlot(List<ParkingSlot> parkingSlots, Vehicle vehicle) {
        //stream
        return parkingSlots.stream()
                .filter(ParkingSlot::isAvailable)
                .filter(slot -> slot.canPark(vehicle))
                .min(Comparator.comparingInt(ParkingSlot::getDistanceFromGate))
                .orElse(null);


//        PriorityQueue<ParkingSlot> queue = new PriorityQueue<>(
//                Comparator.comparingInt(ParkingSlot::getDistanceFromGate)
//        );
//        for (ParkingSlot slot : parkingSlots) {
//            if (slot.isAvailable()
//                    && slot.canPark(vehicle)) {
//                queue.add(slot);
//            }
//        }
//        return queue.poll();
    }
}
