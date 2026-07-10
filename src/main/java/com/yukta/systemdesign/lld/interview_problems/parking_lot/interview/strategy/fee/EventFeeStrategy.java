package com.yukta.systemdesign.lld.interview_problems.parking_lot.interview.strategy.fee;

import com.yukta.systemdesign.lld.interview_problems.parking_lot.interview.domain.Ticket;

import static com.yukta.systemdesign.lld.interview_problems.parking_lot.interview.utils.CommonUtils.DAILY_RATE;
//Fixed parking charge during concerts/events
public class EventFeeStrategy implements FeeStrategy {

    @Override
    public double calculateFee(Ticket ticket) {
        return DAILY_RATE.get(ticket.getVehicle().getVehicleType());
    }
}
