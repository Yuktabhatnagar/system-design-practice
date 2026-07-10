package com.yukta.systemdesign.lld.interview_problems.parking_lot.interview.strategy.payment;


import com.yukta.systemdesign.lld.interview_problems.parking_lot.interview.domain.Receipt;
import com.yukta.systemdesign.lld.interview_problems.parking_lot.interview.domain.Ticket;

public interface PaymentStrategy {

    Receipt pay(Ticket ticket, double amt);
}
