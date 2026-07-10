package com.yukta.systemdesign.lld.interview_problems.vending_machine.controller;
/*
1. Product Listing Use Case:
GET /api/products →
VendingMachineController.getAvailableProducts() →
VendingMachineService.getAvailableProducts() →
Check inventory levels →
Return product list with availability
*/

import com.yukta.systemdesign.lld.interview_problems.vending_machine.domain.Product;
import com.yukta.systemdesign.lld.interview_problems.vending_machine.service.VendingMachineService;

import java.util.List;
import java.util.Map;

public class VendingMachineController {
    private VendingMachineService vendingMachineService;

    public VendingMachineController(VendingMachineService vendingMachineService) {
        this.vendingMachineService = vendingMachineService;
        System.out.println("VendingMachineController initialized");
    }

    public List<Product> getAvailableProducts(int machineId) {
        System.out.println("Controller: Getting available products for machine " + machineId);
        return vendingMachineService.getAvailableProducts(machineId);
    }

    public Product getProductDetails(int machineId, int productId) {
        System.out.println("Controller: Getting product details for product " + productId + " in machine " + machineId);
        return vendingMachineService.getProductDetails(machineId, productId);
    }

    public Map<String, Object> getInventoryStatus(int machineId) {
        System.out.println("Controller: Getting inventory status for machine " + machineId);
        return vendingMachineService.getInventoryStatus(machineId);
    }

    public boolean isProductAvailable(int machineId, int productId) {
        System.out.println("Controller: Checking product availability for product " + productId + " in machine " + machineId);
        return vendingMachineService.isProductAvailable(machineId, productId);
    }

    public int getProductStock(int machineId, int productId) {
        System.out.println("Controller: Getting product stock for product " + productId + " in machine " + machineId);
        return vendingMachineService.getProductStock(machineId, productId);
    }
}
