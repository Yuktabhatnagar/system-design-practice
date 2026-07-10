package com.yukta.systemdesign.lld.interview_problems.parking_lot.interview.domain;

import com.yukta.systemdesign.lld.interview_problems.parking_lot.interview.enums.PaymentMethod;
import com.yukta.systemdesign.lld.interview_problems.parking_lot.interview.enums.PaymentStatus;

import java.time.LocalDateTime;
import java.util.UUID;
//Receipt should be Immutable.
public class Receipt {
    private final UUID receiptId;
    private final Ticket ticket;
    private final double amount;
    private final PaymentMethod paymentMethod;
    private final PaymentStatus paymentStatus;
    private final LocalDateTime paymentTime;


    public Receipt(double amount, Ticket ticket, PaymentMethod method, PaymentStatus status, LocalDateTime paymentTime) {
        this.receiptId = UUID.randomUUID();
        this.amount = amount;
        this.ticket = ticket;
        this.paymentMethod = method;
        this.paymentStatus = status;
        this.paymentTime = paymentTime;
    }

    public double getAmount() {
        return amount;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public PaymentMethod getMethod() {
        return paymentMethod;
    }

    public LocalDateTime getPaymentTime() {
        return paymentTime;
    }

    public PaymentStatus getStatus() {
        return paymentStatus;
    }
}
