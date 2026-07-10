package com.yukta.systemdesign.lld.interview_problems.parking_lot.interview.strategy.parking;

import com.yukta.systemdesign.lld.interview_problems.parking_lot.interview.domain.ParkingSlot;
import com.yukta.systemdesign.lld.interview_problems.parking_lot.interview.domain.Vehicle;

import java.util.List;

public interface ParkingStrategy {

    ParkingSlot findSlot(List<ParkingSlot> parkingSlots,
                         Vehicle vehicle);

}