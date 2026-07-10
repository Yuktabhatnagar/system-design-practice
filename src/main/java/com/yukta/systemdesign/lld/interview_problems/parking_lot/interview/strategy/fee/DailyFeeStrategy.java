package com.yukta.systemdesign.lld.interview_problems.parking_lot.interview.strategy.fee;

import com.yukta.systemdesign.lld.interview_problems.parking_lot.interview.domain.Ticket;

import static com.yukta.systemdesign.lld.interview_problems.parking_lot.interview.utils.CommonUtils.DAILY_RATE;
import static com.yukta.systemdesign.lld.interview_problems.parking_lot.interview.utils.CommonUtils.duration;

//Flat daily rate with extra-day charges: First 24 hrs = ₹1000-> Every additional day = ₹700
public class DailyFeeStrategy implements FeeStrategy {

    @Override
    public double calculateFee(Ticket ticket) {
        // Any partial day is considered a full day
        //+23 is a mathematical trick to perform ceiling division using integers.
        // --> (a + b - 1) / b ; a= hours, b = denominator (24 hours/day)  (hours + 24 - 1) / 24-> (hours + 23) / 24
        //long days = (long) Math.ceil(hours / 24.0);   (Another way)
        long days = (duration(ticket) + 23) / 24;
        return days * DAILY_RATE.get(ticket.getVehicle().getVehicleType());
    }
}
