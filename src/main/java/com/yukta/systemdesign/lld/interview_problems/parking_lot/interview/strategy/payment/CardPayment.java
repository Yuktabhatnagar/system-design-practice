package com.yukta.systemdesign.lld.interview_problems.parking_lot.interview.strategy.payment;

import com.yukta.systemdesign.lld.interview_problems.parking_lot.interview.domain.Receipt;
import com.yukta.systemdesign.lld.interview_problems.parking_lot.interview.domain.Ticket;
import com.yukta.systemdesign.lld.interview_problems.parking_lot.interview.enums.PaymentMethod;
import com.yukta.systemdesign.lld.interview_problems.parking_lot.interview.enums.PaymentStatus;

import java.time.LocalDateTime;

public class CardPayment implements PaymentStrategy {


    @Override
    public Receipt pay(Ticket ticket, double amount) {
//        boolean success = bankGateway.charge(...);
        boolean success = true;
        if(success){
            return new Receipt(amount, ticket, PaymentMethod.CARD_PAYMENT, PaymentStatus.SUCCESS, LocalDateTime.now() );
        }
        return new Receipt(amount, ticket, PaymentMethod.CARD_PAYMENT, PaymentStatus.FAILED, LocalDateTime.now() );

    }
}
