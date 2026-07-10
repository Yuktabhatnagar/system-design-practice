package com.yukta.systemdesign.lld.interview_problems.parking_lot.interview.service;
//Take Amount
//Call Payment Strategy
//Generate Receipt
//- Process payment
//        - Validate payment
//        - Return payment status
//Payment Retry->Logging->Audit->Notification

import com.yukta.systemdesign.lld.interview_problems.parking_lot.interview.domain.Receipt;
import com.yukta.systemdesign.lld.interview_problems.parking_lot.interview.domain.Ticket;
import com.yukta.systemdesign.lld.interview_problems.parking_lot.interview.strategy.payment.PaymentStrategy;

public class PaymentService {
    private final PaymentStrategy paymentStrategy;

    public PaymentService(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public Receipt makePayment(Ticket ticket, double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Invalid payment amount.");
        }

        return paymentStrategy.pay(ticket, amount);
    }

}
