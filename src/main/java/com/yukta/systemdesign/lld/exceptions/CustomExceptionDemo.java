package com.yukta.systemdesign.lld.exceptions;

public class CustomExceptionDemo {

    public static void main(String[] args) {
        PaymentService service = new PaymentService();

        try {
            service.pay(0);
        } catch (InvalidPaymentException exception) {
            System.out.println(exception.getMessage());
        }
    }
}

class PaymentService {

    void pay(double amount) {
        if (amount <= 0) {
            throw new InvalidPaymentException("Payment amount must be positive");
        }

        System.out.println("Payment processed: " + amount);
    }
}

class InvalidPaymentException extends RuntimeException {

    InvalidPaymentException(String message) {
        super(message);
    }
}
