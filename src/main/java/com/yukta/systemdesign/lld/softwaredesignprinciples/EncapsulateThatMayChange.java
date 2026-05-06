package com.yukta.systemdesign.lld.softwaredesignprinciples;

public class EncapsulateThatMayChange {
    public static void main(String[] args) {
        DiscountPolicyEtmc policy = new FestivalDiscountPolicyEtmc();
        PriceCalculatorEtmc calculator = new PriceCalculatorEtmc(policy);

        System.out.println("Final price: " + calculator.finalPrice(1000));
    }
}

// Without encapsulation: discount logic is hardcoded inside the calculator.
class HardcodedPriceCalculatorEtmc {
    public double finalPrice(double price) {
        return price - (price * 0.10);
    }
}

// With encapsulation: changing discount rules does not change the calculator.
class PriceCalculatorEtmc {
    private final DiscountPolicyEtmc discountPolicy;

    public PriceCalculatorEtmc(DiscountPolicyEtmc discountPolicy) {
        this.discountPolicy = discountPolicy;
    }

    public double finalPrice(double price) {
        return price - discountPolicy.discount(price);
    }
}

interface DiscountPolicyEtmc {
    double discount(double price);
}

class RegularDiscountPolicyEtmc implements DiscountPolicyEtmc {
    public double discount(double price) {
        return price * 0.10;
    }
}

class FestivalDiscountPolicyEtmc implements DiscountPolicyEtmc {
    public double discount(double price) {
        return price * 0.25;
    }
}
