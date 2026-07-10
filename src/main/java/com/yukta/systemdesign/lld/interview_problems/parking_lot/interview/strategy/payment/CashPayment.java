package com.yukta.systemdesign.lld.interview_problems.parking_lot.interview.strategy.payment;

import com.yukta.systemdesign.lld.interview_problems.parking_lot.interview.domain.Receipt;
import com.yukta.systemdesign.lld.interview_problems.parking_lot.interview.domain.Ticket;
import com.yukta.systemdesign.lld.interview_problems.parking_lot.interview.enums.PaymentMethod;
import com.yukta.systemdesign.lld.interview_problems.parking_lot.interview.enums.PaymentStatus;

import java.time.LocalDateTime;

public class CashPayment implements PaymentStrategy {

    @Override
    public Receipt pay(Ticket ticket, double amt) {
        boolean success = true;
        if(success){
            return new Receipt(amt, ticket, PaymentMethod.CASH_PAYMENT, PaymentStatus.SUCCESS, LocalDateTime.now() );
        }
        return new Receipt(amt, ticket, PaymentMethod.CASH_PAYMENT, PaymentStatus.FAILED, LocalDateTime.now() );
    }
}
