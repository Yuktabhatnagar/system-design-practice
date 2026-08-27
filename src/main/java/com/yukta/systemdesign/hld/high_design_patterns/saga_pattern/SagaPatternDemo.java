package com.yukta.systemdesign.hld.high_design_patterns.saga_pattern;

import java.util.ArrayList;
import java.util.List;

public class SagaPatternDemo {
    public static void main(String[] args) {
        OrderSaga saga = new OrderSaga(new InventoryService(), new PaymentService(true), new ShippingService());
        saga.placeOrder("order-1", "Laptop", 50000);
    }
}

class OrderSaga {
    private final InventoryService inventoryService;
    private final PaymentService paymentService;
    private final ShippingService shippingService;

    OrderSaga(InventoryService inventoryService, PaymentService paymentService, ShippingService shippingService) {
        this.inventoryService = inventoryService;
        this.paymentService = paymentService;
        this.shippingService = shippingService;
    }

    void placeOrder(String orderId, String item, int amount) {
        List<Runnable> compensations = new ArrayList<>();
        try {
            inventoryService.reserve(item);
            compensations.add(() -> inventoryService.release(item));
            paymentService.charge(orderId, amount);
            compensations.add(() -> paymentService.refund(orderId, amount));
            shippingService.schedule(orderId);
            compensations.add(() -> shippingService.cancel(orderId));
            System.out.println("Saga completed");
        } catch (RuntimeException exception) {
            System.out.println("Saga failed: " + exception.getMessage());
            for (int i = compensations.size() - 1; i >= 0; i--) {
                compensations.get(i).run();
            }
        }
    }
}

class InventoryService {
    void reserve(String item) { System.out.println("Reserved " + item); }
    void release(String item) { System.out.println("Released " + item); }
}

class PaymentService {
    private final boolean fail;
    PaymentService(boolean fail) { this.fail = fail; }
    void charge(String orderId, int amount) {
        if (fail) { throw new IllegalStateException("Payment failed"); }
        System.out.println("Charged " + amount);
    }
    void refund(String orderId, int amount) { System.out.println("Refunded " + amount + " for " + orderId); }
}

class ShippingService {
    void schedule(String orderId) { System.out.println("Shipping scheduled for " + orderId); }
    void cancel(String orderId) { System.out.println("Shipping cancelled for " + orderId); }
}
