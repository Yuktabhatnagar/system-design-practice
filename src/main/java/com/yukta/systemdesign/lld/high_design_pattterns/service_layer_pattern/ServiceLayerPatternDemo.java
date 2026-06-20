package com.yukta.systemdesign.lld.high_design_pattterns.service_layer_pattern;

public class ServiceLayerPatternDemo {

    public static void main(String[] args) {
        CheckoutService checkoutService = new CheckoutService(new InventoryService(), new BillingService());

        checkoutService.checkout("Book", 499);
    }
}

class CheckoutService {

    private final InventoryService inventoryService;
    private final BillingService billingService;

    CheckoutService(InventoryService inventoryService, BillingService billingService) {
        this.inventoryService = inventoryService;
        this.billingService = billingService;
    }

    void checkout(String item, int price) {
        inventoryService.reserve(item);
        billingService.charge(price);
        System.out.println("Checkout completed");
    }
}

class InventoryService {

    void reserve(String item) {
        System.out.println("Reserved item: " + item);
    }
}

class BillingService {

    void charge(int amount) {
        System.out.println("Charged amount: " + amount);
    }
}
