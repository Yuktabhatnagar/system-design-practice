
package com.yukta.systemdesign.lld.designpatterns.creational.factory;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

interface Vehicle {
    void drive();
}

class Car implements Vehicle {

    static {
        VehicleFactory.register("car", Car::new);
    }

    public void drive() {
        System.out.println("Driving Car");
    }
}

class Bike implements Vehicle {
    static {
        VehicleFactory.register("bike", Bike::new);
    }

    public void drive() {
        System.out.println("Driving Bike");
    }
}

//added later
class Truck implements Vehicle {
    static {
        VehicleFactory.register("truck", Truck::new);
    }

    @Override
    public void drive() {
        System.out.println("Driving truck");
    }
}

class VehicleFactory {
    private static Map<String, Supplier<Vehicle>> map = new HashMap<>();

    public static void register(String type, Supplier<Vehicle> supplier) {
        map.put(type, supplier);
    }

    public static Vehicle getVehicle(String type) {
        Supplier<Vehicle> supplier = map.get(type);
        if (supplier != null) {
            return supplier.get();
        }
        throw new IllegalArgumentException("Invalid type");
    }
}

public class FactoryDemo {
    public static void main(String[] args) throws ClassNotFoundException {

        //👉 Class.forName() forces JVM to: Load class, Execute static block & Register in factory
        Class.forName(Car.class.getName());  // force loading ❌
        Class.forName(Bike.class.getName());
        Class.forName(Truck.class.getName());

        Vehicle v = VehicleFactory.getVehicle("car");
        v.drive();

//        Self-registration requires class loading; otherwise, factory won’t know about implementations.
    }
}