package com.yukta.systemdesign.lld.designpatterns.creational.builder;

class BurgerMeal1 {

    private String bun;
    private String patty;
    private boolean cheese;
    private String side;
    private String drink;
//Telescoping Constructor Anti-Pattern
    public BurgerMeal1(String bun, String patty) {
        this.bun = bun;
        this.patty = patty;
    }

    public BurgerMeal1(String bun, String patty, boolean cheese) {
        this(bun, patty);
        this.cheese = cheese;
    }

    public BurgerMeal1(String bun, String patty, boolean cheese, String side) {
        this(bun, patty, cheese);
        this.side = side;
    }

    public BurgerMeal1(String bun, String patty, boolean cheese, String side, String drink) {
        this(bun, patty, cheese, side);
        this.drink = drink;
    }
}