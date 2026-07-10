package com.yukta.systemdesign.lld.interview_problems.vending_machine.domain.state;


import com.yukta.systemdesign.lld.interview_problems.vending_machine.domain.PaymentRequest;
import com.yukta.systemdesign.lld.interview_problems.vending_machine.domain.Transaction;
import com.yukta.systemdesign.lld.interview_problems.vending_machine.domain.VendingMachine;

public class DispensingState implements VendingMachineState {

    @Override
    public Transaction processPayment(VendingMachine machine, PaymentRequest request) {
        System.out.println("DispensingState: Cannot process new payment while dispensing");
        // Cannot process new payment while dispensing
        return null;
    }

    @Override
    public void cancelPayment(VendingMachine machine, int transactionId) {
        System.out.println("DispensingState: Cannot cancel payment while dispensing");
        // Cannot cancel payment while dispensing
    }

    @Override
    public String getStateName() {
        return "DISPENSING";
    }
}

