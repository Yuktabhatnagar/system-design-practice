package com.yukta.systemdesign.lld.interview_problems.parking_lot.interview.strategy.fee;

import com.yukta.systemdesign.lld.interview_problems.parking_lot.interview.domain.Ticket;

//Standard hourly fee + 20% weekend surcharge
public class WeekendFeeStrategy implements FeeStrategy {

    private final FeeStrategy baseStrategy;

    public WeekendFeeStrategy(FeeStrategy baseStrategy) {
        this.baseStrategy = baseStrategy;
    }

    @Override
    public double calculateFee(Ticket ticket) {
        //Weekend Charge = +20%
        return baseStrategy.calculateFee(ticket) * 1.20;
    }
}
