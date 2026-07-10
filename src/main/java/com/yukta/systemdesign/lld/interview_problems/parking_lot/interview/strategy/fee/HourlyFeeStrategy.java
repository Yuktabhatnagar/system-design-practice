package com.yukta.systemdesign.lld.interview_problems.parking_lot.interview.strategy.fee;
/*You'll also learn
Duration
ChronoUnit
LocalDateTime
Very useful for interviews.*/

import com.yukta.systemdesign.lld.interview_problems.parking_lot.interview.domain.Ticket;

import static com.yukta.systemdesign.lld.interview_problems.parking_lot.interview.utils.CommonUtils.HOURLY_RATE;
import static com.yukta.systemdesign.lld.interview_problems.parking_lot.interview.utils.CommonUtils.duration;

//Standard hourly billing based on vehicle type
public class HourlyFeeStrategy implements FeeStrategy {

    @Override
    public double calculateFee(Ticket ticket) {
        return duration(ticket) * HOURLY_RATE.get(ticket.getVehicle().getVehicleType());
    }
}
