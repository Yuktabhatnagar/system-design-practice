package com.yukta.systemdesign.lld.interview_problems.parking_lot.interview.strategy.fee;

import com.yukta.systemdesign.lld.interview_problems.parking_lot.interview.domain.Ticket;

//First 2 hours FREE, Remaining charged normally
//Hourly Fee-> 20% Discount
//Fixed Monthly Membership: VIP Member-> Flat ₹100 -> Unlimited parking for the day
//First 2 hours free, then 20% discount on remaining fee
public class VIPFeeStrategy implements FeeStrategy {
    private final FeeStrategy baseStrategy;

    public VIPFeeStrategy(FeeStrategy baseStrategy) {
        this.baseStrategy = baseStrategy;
    }

    @Override
    public double calculateFee(Ticket ticket) {
        return baseStrategy.calculateFee(ticket) * 0.80;
    }
}
