package com.yukta.systemdesign.lld.designpatterns.creational.abstractfactorypattern;

// ========== Interfaces ==========
interface PaymentGateway1 {
    void processPayment(double amount);
}

interface Invoice1 {
    void generateInvoice();
}

// ========== India Implementations ==========
class RazorpayGateway1 implements PaymentGateway1 {
    public void processPayment(double amount) {
        System.out.println("Processing INR payment via Razorpay: " + amount);
    }
}

class PayUGateway1 implements PaymentGateway1 {
    public void processPayment(double amount) {
        System.out.println("Processing INR payment via PayU: " + amount);
    }
}

class GSTInvoice1 implements Invoice1 {
    public void generateInvoice() {
        System.out.println("Generating GST Invoice for India.");
    }
}

// ========== US Implementations ==========
class PayPalGateway implements PaymentGateway1 {
    public void processPayment(double amount) {
        System.out.println("Processing USD payment via PayPal: " + amount);
    }
}

class StripeGateway implements PaymentGateway1 {
    public void processPayment(double amount) {
        System.out.println("Processing USD payment via Stripe: " + amount);
    }
}

class USInvoice implements Invoice1 {
    public void generateInvoice() {
        System.out.println("Generating Invoice as per US norms.");
    }
}

// ========== Abstract Factory ==========
interface RegionFactory {
    PaymentGateway1 createPaymentGateway(String gatewayType);
    Invoice1 createInvoice();
}

// ========== Concrete Factories ==========
class IndiaFactory implements RegionFactory {
    public PaymentGateway1 createPaymentGateway(String gatewayType) {
        if (gatewayType.equalsIgnoreCase("razorpay")) {
            return new RazorpayGateway1();
        } else if (gatewayType.equalsIgnoreCase("payu")) {
            return new PayUGateway1();
        }
        throw new IllegalArgumentException("Unsupported gateway for India: " + gatewayType);
    }

    public Invoice1 createInvoice() {
        return new GSTInvoice1();
    }
}

class USFactory implements RegionFactory {
    public PaymentGateway1 createPaymentGateway(String gatewayType) {
        if (gatewayType.equalsIgnoreCase("paypal")) {
            return new PayPalGateway();
        } else if (gatewayType.equalsIgnoreCase("stripe")) {
            return new StripeGateway();
        }
        throw new IllegalArgumentException("Unsupported gateway for US: " + gatewayType);
    }

    public Invoice1 createInvoice() {
        return new USInvoice();
    }
}

// ========== Checkout Service ==========
class CheckoutService1 {
    private PaymentGateway1 paymentGateway;
    private Invoice1 invoice;
    private String gatewayType;

    public CheckoutService1(RegionFactory factory, String gatewayType) {
        this.gatewayType = gatewayType;
        this.paymentGateway = factory.createPaymentGateway(gatewayType);
        this.invoice = factory.createInvoice();
    }

    public void completeOrder(double amount) {
        paymentGateway.processPayment(amount);
        invoice.generateInvoice();
    }
}

// ========== Main Method ==========
public class AbstractFactoryDemo {
    public static void main(String[] args) {
        // Using Razorpay in India
        CheckoutService1 indiaCheckout = new CheckoutService1(new IndiaFactory(), "razorpay");
        indiaCheckout.completeOrder(1999.0);

        System.out.println("---");

        // Using PayPal in US
        CheckoutService1 usCheckout = new CheckoutService1(new USFactory(), "paypal");
        usCheckout.completeOrder(49.99);
    }
}

