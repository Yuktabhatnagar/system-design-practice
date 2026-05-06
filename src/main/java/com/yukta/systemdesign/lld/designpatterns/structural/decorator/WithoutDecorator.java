package com.yukta.systemdesign.lld.designpatterns.structural.decorator;

// Each combination of pizza requires a new class
class PlainPizza {}
class CheesePizza extends PlainPizza1 {}
class OlivePizza extends PlainPizza1 {}
class StuffedPizza extends PlainPizza1 {}
class CheeseStuffedPizza extends CheesePizza {}
class CheeseOlivePizza extends CheesePizza {}
class CheeseOliveStuffedPizza extends CheeseOlivePizza {}

public class WithoutDecorator {
    public static void main(String[] args) {
        // Base pizza
        PlainPizza1 plainPizza = new PlainPizza1();

        // Pizzas with individual toppings
        CheesePizza cheesePizza = new CheesePizza();
        OlivePizza olivePizza = new OlivePizza();
        StuffedPizza stuffedPizza = new StuffedPizza();

        // Combinations of toppings require separate classes
        CheeseStuffedPizza cheeseStuffedPizza = new CheeseStuffedPizza();
        CheeseOlivePizza cheeseOlivePizza = new CheeseOlivePizza();

        // Further combinations increase complexity exponentially
        CheeseOliveStuffedPizza cheeseOliveStuffedPizza = new CheeseOliveStuffedPizza();

    }
}
