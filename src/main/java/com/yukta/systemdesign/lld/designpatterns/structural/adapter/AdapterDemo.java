package com.yukta.systemdesign.lld.designpatterns.structural.adapter;

import java.util.*;

// Target Interface:
// Standard interface expected by the CheckoutService
interface PaymentGateway1 {
    void pay(String orderId, double amount);
}

// Concrete implementation of PaymentGateway for PayU
class PayUGateway1 implements PaymentGateway1 {
    @Override
    public void pay(String orderId, double amount) {
        System.out.println("Paid Rs." + amount + " using PayU for order: " + orderId);
    }
}

// Adaptee:
// An existing class with an incompatible interface
class RazorpayAPI1 {
    public void makePayment(String invoiceId, double amountInRupees) {
        System.out.println("Paid Rs." + amountInRupees + " using Razorpay for invoice: " + invoiceId);
    }
}

// Adapter Class:
// Allows RazorpayAPI to be used where PaymentGateway is expected
class RazorpayAdapter implements PaymentGateway1 {
    private RazorpayAPI1 razorpayAPI;

    public RazorpayAdapter() {
        this.razorpayAPI = new RazorpayAPI1();
    }

    // Translates the pay() call to RazorpayAPI's makePayment() method
    @Override
    public void pay(String orderId, double amount) {
        razorpayAPI.makePayment(orderId, amount);
    }
}


// Client Class:
// Uses PaymentGateway interface to process payments
class CheckoutService1 {
    private PaymentGateway1 paymentGateway;

    // Constructor injection for dependency inversion
    public CheckoutService1(PaymentGateway1 paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    // Business logic to perform checkout
    public void checkout(String orderId, double amount) {
        paymentGateway.pay(orderId, amount);
    }
}

public class AdapterDemo {
    public static void main(String[] args) {
        // Using razorpay payment gateway adapter to process payment
        CheckoutService1 checkoutService =
                new CheckoutService1(new RazorpayAdapter());

        checkoutService.checkout("12", 1780);
    }
}

