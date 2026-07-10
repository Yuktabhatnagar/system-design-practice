package com.yukta.systemdesign.lld.interview_problems.parking_lot.interview.utils;

import com.yukta.systemdesign.lld.interview_problems.parking_lot.interview.domain.Ticket;
import com.yukta.systemdesign.lld.interview_problems.parking_lot.interview.enums.VehicleType;

import java.time.Duration;
import java.util.Map;

public class CommonUtils {
    public static final Map<VehicleType, Double> HOURLY_RATE = Map.of(
            VehicleType.BIKE, 20.0,
            VehicleType.CAR, 50.0,
            VehicleType.TRUCK, 80.0
    );

    public static final Map<VehicleType, Double> DAILY_RATE = Map.of(
            VehicleType.BIKE, 400.0,
            VehicleType.CAR, 1000.0,
            VehicleType.TRUCK, 1500.0
    );

    public static long duration(Ticket ticket) {
        return Duration.between(
                ticket.getEntryTime(),
                ticket.getExitTime()
        ).toHours();
    }

}
