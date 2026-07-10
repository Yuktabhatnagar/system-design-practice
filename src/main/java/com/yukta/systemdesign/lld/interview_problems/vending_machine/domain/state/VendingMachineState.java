package com.yukta.systemdesign.lld.interview_problems.vending_machine.domain.state;


import com.yukta.systemdesign.lld.interview_problems.vending_machine.domain.PaymentRequest;
import com.yukta.systemdesign.lld.interview_problems.vending_machine.domain.Transaction;
import com.yukta.systemdesign.lld.interview_problems.vending_machine.domain.VendingMachine;

public interface VendingMachineState {
    Transaction processPayment(VendingMachine machine, PaymentRequest request);

    void cancelPayment(VendingMachine machine, int transactionId);

    String getStateName();
}