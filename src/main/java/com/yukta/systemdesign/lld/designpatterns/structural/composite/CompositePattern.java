package com.yukta.systemdesign.lld.designpatterns.structural.composite;

import java.util.*;

// Interface for items that can be added to the cart
interface CartItem {
    double getPrice();
    void display(String indent);
}

// Product class implementing CartItem
class Product2 implements CartItem {
    private String name;
    private double price;

    public Product2(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void display(String indent) {
        System.out.println(indent + "Product: " + name + " - ₹" + price);
    }
}

// ProductBundle class implementing CartItem
class ProductBundle2 implements CartItem {
    private String bundleName;
    private List<CartItem> items = new ArrayList<>();

    public ProductBundle2(String bundleName) {
        this.bundleName = bundleName;
    }

    public void addItem(CartItem item) {
        items.add(item);
    }

    @Override
    public double getPrice() {
        double total = 0;
        for (CartItem item : items) {
            total += item.getPrice();
        }
        return total;
    }

    @Override
    public void display(String indent) {
        System.out.println(indent + "Bundle: " + bundleName);
        for (CartItem item : items) {
            item.display(indent + "  ");
        }
    }
}

// Main class
class CompositePattern {
    public static void main(String[] args) {
        // Individual Products
        CartItem book = new Product2("Atomic Habits",499);
        CartItem phone = new Product2("iPhone 15", 79999);
        CartItem earbuds = new Product2("AirPods", 15999);
        CartItem charger = new Product2("20W Charger", 1999);

        // Combo Deal
        ProductBundle2 iphoneCombo = new ProductBundle2("iPhone Essentials Combo");
        iphoneCombo.addItem(phone);
        iphoneCombo.addItem(earbuds);
        iphoneCombo.addItem(charger);

        // Back to School Kit
        ProductBundle2 schoolKit = new ProductBundle2("Back to School Kit");
        schoolKit.addItem(new Product2("Notebook Pack", 249));
        schoolKit.addItem(new Product2("Pen Set", 99));
        schoolKit.addItem(new Product2("Highlighter", 149));

        // Add everything to cart
        List<CartItem> cart = new ArrayList<>();
        cart.add(book);
        cart.add(iphoneCombo);
        cart.add(schoolKit);

        // Display cart
        System.out.println("Your Amazon Cart:");
        double total = 0;
        for (CartItem item : cart) {
            item.display("  ");
            total += item.getPrice();
        }

        System.out.println("\nTotal: ₹" + total);
    }
}

