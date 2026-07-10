package com.yukta.systemdesign.lld.solid.lsp;

interface Vehicle {
    void accelerate();
}

interface EngineVehicle extends Vehicle {
    void turnOnEngine();
}

class MotorCycle1 implements EngineVehicle {
    private boolean engineOn;
    private int speed;

    @Override
    public void turnOnEngine() {
        engineOn = true;
        System.out.println("Motorcycle engine started");
    }

    @Override
    public void accelerate() {
        if (!engineOn) {
            throw new IllegalStateException("Start engine before accelerating");
        }

        speed += 10;
        System.out.println("Motorcycle speed: " + speed);
    }
}

class Bicycle1 implements Vehicle {
    private int speed;

    @Override
    public void accelerate() {
        speed += 5;
        System.out.println("Bicycle speed: " + speed);
    }
}

public class LiskovSubstitutionPrinciple {
    public static void main(String[] args) {
        Vehicle bicycle = new Bicycle1();
        bicycle.accelerate();

        EngineVehicle motorCycle = new MotorCycle1();
        motorCycle.turnOnEngine();
        motorCycle.accelerate();
    }
}

