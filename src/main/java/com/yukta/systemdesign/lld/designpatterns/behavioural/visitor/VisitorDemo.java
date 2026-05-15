package com.yukta.systemdesign.lld.designpatterns.behavioural.visitor;

import java.util.*;

// ======= Element Interface ==========
interface Item {
    void accept(ItemVisitor1 visitor);
}

// ======= Concrete elements ===========
class PhysicalProduct1 implements Item {
    String name;
    double weight;

    public PhysicalProduct1(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    public void accept(ItemVisitor1 visitor) {
        visitor.visit(this);
    }
}

// ======= Concrete elements ===========
class DigitalProduct1 implements Item {
    String name;
    int downloadSizeInMB;

    public DigitalProduct1(String name, int downloadSizeInMB) {
        this.name = name;
        this.downloadSizeInMB = downloadSizeInMB;
    }

    public void accept(ItemVisitor1 visitor) {
        visitor.visit(this);
    }
}

// ======= Concrete elements ===========
class GiftCard1 implements Item {
    String code;
    double amount;

    public GiftCard1(String code, double amount) {
        this.code = code;
        this.amount = amount;
    }

    public void accept(ItemVisitor1 visitor) {
        visitor.visit(this);
    }
}

// ======== Visitor Interface ============
interface ItemVisitor1{
    void visit(PhysicalProduct1 item);
    void visit(DigitalProduct1 item);
    void visit(GiftCard1 item);
}

// ============ Concrete Visitors ==============
class InvoiceVisitor1 implements ItemVisitor1 {
    public void visit(PhysicalProduct1 item) {
        System.out.println("Invoice: " + item.name + " - Shipping to customer");
    }

    public void visit(DigitalProduct1 item) {
        System.out.println("Invoice: " + item.name + " - Email with download link");
    }

    public void visit(GiftCard1 item) {
        System.out.println("Invoice: Gift Card - Code: " + item.code);
    }
}

// ============ Concrete Visitors ==============
class ShippingCostVisitor implements ItemVisitor1 {
    public void visit(PhysicalProduct1 item) {
        System.out.println("Shipping cost for " + item.name + ": Rs. " + (item.weight * 10));
    }

    public void visit(DigitalProduct1 item) {
        System.out.println(item.name + " is digital -- No shipping cost.");
    }

    public void visit(GiftCard1 item) {
        System.out.println("GiftCard delivery via email -- No shipping cost.");
    }
}

// Client Code
public class VisitorDemo {
    public static void main(String[] args) {
        List<Item> items = new ArrayList<>();
        items.add(new PhysicalProduct1("Shoes", 1.2));
        items.add(new DigitalProduct1("Ebook", 100));
        items.add(new GiftCard1("TUF500", 500));

        ItemVisitor1 invoiceGenerator = new InvoiceVisitor1();
        ItemVisitor1 shippingCalculator = new ShippingCostVisitor();

        for (Item item : items) {
            item.accept(invoiceGenerator);
            item.accept(shippingCalculator);

            System.out.println("");
        }
    }
}
