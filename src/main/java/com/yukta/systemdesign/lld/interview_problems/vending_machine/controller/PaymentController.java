package com.yukta.systemdesign.lld.interview_problems.vending_machine.controller;
/*
* 2. Payment Processing Use Case:
POST /api/payment →
PaymentController.processPayment() →
PaymentService.processPayment() →
Validate inventory →
Check state (must be IdleState) →
Change state to ProcessingPaymentState →
Process payment →
Update inventory →
Change state to DispensingState →
Dispense product →
Change state back to IdleState →
Return transaction
* */

/*
* 3. Payment Cancel/Failure Use Case:
POST /api/payment/cancel →
PaymentController.cancelPayment() →
PaymentService.cancelPayment() →
Rollback inventory →
Refund money →
Log failure →
Change state back to IdleState →
Reset state
* */
import com.yukta.systemdesign.lld.interview_problems.vending_machine.domain.Denomination;
import com.yukta.systemdesign.lld.interview_problems.vending_machine.domain.PaymentRequest;
import com.yukta.systemdesign.lld.interview_problems.vending_machine.domain.Transaction;
import com.yukta.systemdesign.lld.interview_problems.vending_machine.service.PaymentService;

import java.util.List;
import java.util.Map;

public class PaymentController {
    private PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
        System.out.println("PaymentController initialized");
    }

    public Transaction processPayment(int machineId, PaymentRequest request) {
        System.out.println("Controller: Processing payment for machine " + machineId + ", product " + request.getProductId());
        return paymentService.processPayment(machineId, request);
    }

    public void cancelPayment(int machineId, int transactionId) {
        System.out.println("Controller: Cancelling payment for machine " + machineId + ", transaction " + transactionId);
        paymentService.cancelPayment(machineId, transactionId);
    }

    public String getPaymentStatus(int machineId, int transactionId) {
        System.out.println("Controller: Getting payment status for machine " + machineId + ", transaction " + transactionId);
        return paymentService.getPaymentStatus(machineId, transactionId);
    }

    public List<Transaction> getTransactionHistory(int machineId) {
        System.out.println("Controller: Getting transaction history for machine " + machineId);
        return paymentService.getTransactionHistory(machineId);
    }

    public double getTotalCashInMachine(int machineId) {
        System.out.println("Controller: Getting total cash in machine " + machineId);
        return paymentService.getTotalCashInMachine(machineId);
    }

    public Map<Denomination, Integer> getCashBoxStatus(int machineId) {
        System.out.println("Controller: Getting cash box status for machine " + machineId);
        return paymentService.getCashBoxStatus(machineId);
    }
}

