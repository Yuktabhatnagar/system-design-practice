package com.yukta.systemdesign.lld.interview_problems.parking_lot.practice.adapter;

import java.util.UUID;

public interface PaymentGatewayAdapter {
    boolean pay(UUID ticketId, double amount);
}
