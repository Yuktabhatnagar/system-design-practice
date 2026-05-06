package com.yukta.systemdesign.lld.softwaredesignprinciples;

public class YAGNI {
    public static void main(String[] args) {
        SimpleInvoicePrinter invoicePrinter = new SimpleInvoicePrinter();
        invoicePrinter.printInvoice("INV-101", 1500);
    }
}

// Without YAGNI: supports features that are not needed yet.
class OverEngineeredInvoicePrinter {
    public void printInvoice(String invoiceId, double amount, String exportFormat, boolean sendEmail) {
        System.out.println("Invoice: " + invoiceId);
        System.out.println("Amount: " + amount);

        if ("pdf".equalsIgnoreCase(exportFormat)) {
            System.out.println("Exporting PDF");
        }

        if (sendEmail) {
            System.out.println("Sending invoice email");
        }
    }
}

// With YAGNI: implements only the current requirement.
class SimpleInvoicePrinter {
    public void printInvoice(String invoiceId, double amount) {
        System.out.println("Invoice: " + invoiceId);
        System.out.println("Amount: " + amount);
    }
}
