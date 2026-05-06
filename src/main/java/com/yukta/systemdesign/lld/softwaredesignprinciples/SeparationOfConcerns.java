package com.yukta.systemdesign.lld.softwaredesignprinciples;

public class SeparationOfConcerns {
    public static void main(String[] args) {
        OrderRepositorySoc repository = new OrderRepositorySoc();
        OrderEmailSenderSoc emailSender = new OrderEmailSenderSoc();
        OrderServiceSoc orderService = new OrderServiceSoc(repository, emailSender);

        orderService.placeOrder("ORD-101", "raj@example.com");
    }
}

// Without separation: one class does business logic, persistence, and notification.
class MixedOrderServiceSoc {
    public void placeOrder(String orderId, String customerEmail) {
        System.out.println("Validating order " + orderId);
        System.out.println("Saving order " + orderId + " to database");
        System.out.println("Sending confirmation email to " + customerEmail);
    }
}

// With separation: each class has one concern.
class OrderServiceSoc {
    private final OrderRepositorySoc repository;
    private final OrderEmailSenderSoc emailSender;

    public OrderServiceSoc(OrderRepositorySoc repository, OrderEmailSenderSoc emailSender) {
        this.repository = repository;
        this.emailSender = emailSender;
    }

    public void placeOrder(String orderId, String customerEmail) {
        System.out.println("Validating order " + orderId);
        repository.save(orderId);
        emailSender.sendConfirmation(customerEmail);
    }
}

class OrderRepositorySoc {
    public void save(String orderId) {
        System.out.println("Saving order " + orderId + " to database");
    }
}

class OrderEmailSenderSoc {
    public void sendConfirmation(String customerEmail) {
        System.out.println("Sending confirmation email to " + customerEmail);
    }
}
