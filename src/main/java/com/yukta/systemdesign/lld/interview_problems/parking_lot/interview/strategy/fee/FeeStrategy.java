package com.yukta.systemdesign.lld.interview_problems.parking_lot.interview.strategy.fee;

import com.yukta.systemdesign.lld.interview_problems.parking_lot.interview.domain.Ticket;

public interface FeeStrategy {

    public double calculateFee(Ticket ticket);
}
