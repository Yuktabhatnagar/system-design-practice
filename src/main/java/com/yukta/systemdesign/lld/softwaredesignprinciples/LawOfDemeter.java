package com.yukta.systemdesign.lld.softwaredesignprinciples;

public class LawOfDemeter {
    public static void main(String[] args) {
        CustomerLod customer = new CustomerLod(new WalletLod(1200));
        CheckoutServiceLod checkoutService = new CheckoutServiceLod();

        checkoutService.checkout(customer, 500);
    }
}

class WalletLod {
    private double balance;

    public WalletLod(double balance) {
        this.balance = balance;
    }

    public boolean hasEnoughBalance(double amount) {
        return balance >= amount;
    }
}

class CustomerLod {
    private final WalletLod wallet;

    public CustomerLod(WalletLod wallet) {
        this.wallet = wallet;
    }

    // Without Law of Demeter, callers may ask for wallet and then inspect it.
    public WalletLod getWallet() {
        return wallet;
    }

    // With Law of Demeter, callers ask customer directly.
    public boolean canPay(double amount) {
        return wallet.hasEnoughBalance(amount);
    }
}

class CheckoutServiceLod {
    public void checkoutBad(CustomerLod customer, double amount) {
        if (customer.getWallet().hasEnoughBalance(amount)) {
            System.out.println("Payment allowed");
        }
    }

    public void checkout(CustomerLod customer, double amount) {
        if (customer.canPay(amount)) {
            System.out.println("Payment allowed");
        }
    }
}
