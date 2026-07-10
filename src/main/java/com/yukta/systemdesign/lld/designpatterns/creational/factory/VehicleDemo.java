package com.yukta.systemdesign.lld.designpatterns.creational.factory;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Map;

// Factory through Spring DI
public class VehicleDemo {
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context =
                     new AnnotationConfigApplicationContext(VehicleFactoryConfig.class)) {
            SpringVehicleFactory vehicleFactory = context.getBean(SpringVehicleFactory.class);

            VehicleDi car = vehicleFactory.getVehicle("car");
            car.drive();

            VehicleDi bike = vehicleFactory.getVehicle("bike");
            bike.drive();
        }
    }
}

interface VehicleDi {
    void drive();
}

@Component("car")
class CarVehicle implements VehicleDi {
    public void drive() {
        System.out.println("Driving Car");
    }
}

@Component("bike")
class BikeVehicle implements VehicleDi {
    public void drive() {
        System.out.println("Driving Bike");
    }
}

@Component
class SpringVehicleFactory {

    private final Map<String, VehicleDi> vehicleMap;

    public SpringVehicleFactory(Map<String, VehicleDi> vehicleMap) {
        this.vehicleMap = vehicleMap;
    }

    public VehicleDi getVehicle(String type) {
        VehicleDi vehicle = vehicleMap.get(type);
        if (vehicle == null) {
            throw new IllegalArgumentException("Invalid vehicle type: " + type);
        }
        return vehicle;
    }
}

@Configuration
@ComponentScan(basePackageClasses = VehicleDemo.class)
class VehicleFactoryConfig {
}
