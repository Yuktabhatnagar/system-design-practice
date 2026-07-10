package com.yukta.systemdesign.lld.softwaredesignprinciples;

public class LowCouplingHighCohesion {
    public static void main(String[] args) {
        PaymentProcessorLch processor = new PaymentProcessorLch(new UpiPaymentGatewayLch());
        processor.pay(799);
    }
}

// Without low coupling: directly depends on one concrete gateway.
class TightlyCoupledPaymentProcessorLch {
    private final RazorpayGatewayLch gateway = new RazorpayGatewayLch();

    public void pay(double amount) {
        gateway.charge(amount);
    }
}

// With low coupling: depends on an abstraction.
class PaymentProcessorLch {
    private final PaymentGatewayLch gateway;

    public PaymentProcessorLch(PaymentGatewayLch gateway) {
        this.gateway = gateway;
    }

    public void pay(double amount) {
        gateway.charge(amount);
    }
}

interface PaymentGatewayLch {
    void charge(double amount);
}

class RazorpayGatewayLch implements PaymentGatewayLch {
    public void charge(double amount) {
        System.out.println("Charging " + amount + " using Razorpay");
    }
}

class UpiPaymentGatewayLch implements PaymentGatewayLch {
    public void charge(double amount) {
        System.out.println("Charging " + amount + " using UPI");
    }
}
