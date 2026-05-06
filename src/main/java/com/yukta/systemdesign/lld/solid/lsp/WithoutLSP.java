package com.yukta.systemdesign.lld.solid.lsp;

class MotorCycle implements Bike {
    boolean isEngine;
    int speed;

    @Override
    public void turnOnEngine() {
        isEngine = true;
    }

    @Override
    public void accelerate() {
        speed = speed + 10;
    }
}

class Bicycle implements Bike {
    boolean isEngine;
    int speed;

    @Override
    public void turnOnEngine() {
        isEngine = false;
System.out.println(isEngine);
}
    @Override
    public void accelerate() {
        speed = speed + 5;
    }
}

interface Bike {
    public void turnOnEngine();

    public void accelerate();
}


public class WithoutLSP {
    public static void main(String[] args) {
        Bike bike = new Bicycle();
        bike.turnOnEngine();
    }
}
