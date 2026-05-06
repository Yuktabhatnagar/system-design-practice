package com.yukta.systemdesign.lld.solid.ocp;

// OPEN CLOSED PRINCIPLE
// Open for extension, closed for modification

public class InvoiceService {

    private TaxCalculator taxCalculator;

    public InvoiceService(TaxCalculator taxCalculator) {
        this.taxCalculator = taxCalculator;
    }

    public double calculate(double amount) {
        return taxCalculator.amountAfterTax(amount);
    }

    public static void main(String[] args) {
        TaxCalculator calculator = new GSTCalculator();
        InvoiceService invoiceService = new InvoiceService(calculator);
        System.out.println(invoiceService.calculate(100));
    }
}

interface TaxCalculator {
    double amountAfterTax(double amount);
}

class GSTCalculator implements TaxCalculator {
    public double amountAfterTax(double amount) {
        return amount + 0.18 * amount;
    }
}