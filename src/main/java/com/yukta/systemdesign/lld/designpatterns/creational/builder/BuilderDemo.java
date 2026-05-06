package com.yukta.systemdesign.lld.designpatterns.creational.builder;

import java.util.*;

// Represents a customizable Burger Meal
class BurgerMeal2 {
    // Required components
    private final String bunType;
    private final String patty;

    // Optional components
    private final boolean hasCheese;
    private final List<String> toppings;
    private final String side;
    private final String drink;

    // Private constructor to force use of Builder
    private BurgerMeal2(BurgerBuilder builder) {
        this.bunType = builder.bunType;
        this.patty = builder.patty;
        this.hasCheese = builder.hasCheese;
        this.toppings = builder.toppings;
        this.side = builder.side;
        this.drink = builder.drink;
    }

    // Static nested Builder class
    public static class BurgerBuilder {
        // Required
        private final String bunType;
        private final String patty;

        // Optional
        private boolean hasCheese;
        private List<String> toppings;
        private String side;
        private String drink;

        // Builder constructor with required fields
        public BurgerBuilder(String bunType, String patty) {
            this.bunType = bunType;
            this.patty = patty;
        }

        // Method to set cheese
        public BurgerBuilder withCheese(boolean hasCheese) {
            this.hasCheese = hasCheese;
            return this;
        }

        // Method to set toppings
        public BurgerBuilder withToppings(List<String> toppings) {
            this.toppings = toppings;
            return this;
        }

        // Method to set side
        public BurgerBuilder withSide(String side) {
            this.side = side;
            return this;
        }

        // Method to set drink
        public BurgerBuilder withDrink(String drink) {
            this.drink = drink;
            return this;
        }

        // Final build method
        public BurgerMeal2 build() {
            return new BurgerMeal2(this);
        }
    }
}

public class BuilderDemo {
    public static void main(String[] args) {
        // Creating burger with only required fields
        BurgerMeal2 plainBurger = new BurgerMeal2.BurgerBuilder("wheat", "veg")
                .build();

        // Burger with cheese only
        BurgerMeal2 burgerWithCheese = new BurgerMeal2.BurgerBuilder("wheat", "veg")
                .withCheese(true)
                .build();

        // Fully loaded burger
        List<String> toppings = Arrays.asList("lettuce", "onion", "jalapeno");
        BurgerMeal2 loadedBurger = new BurgerMeal2.BurgerBuilder("multigrain", "chicken")
                .withCheese(true)
                .withToppings(toppings)
                .withSide("fries")
                .withDrink("coke")
                .build();
    }
}

