package com.yukta.systemdesign.lld.designpatterns.creational.factory;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SpringVehicleFactoryTest {

    @Test
    void getsVehiclesFromSpringInjectedMap() {
        try (AnnotationConfigApplicationContext context =
                     new AnnotationConfigApplicationContext(VehicleFactoryConfig.class)) {
            SpringVehicleFactory factory = context.getBean(SpringVehicleFactory.class);

            assertInstanceOf(CarVehicle.class, factory.getVehicle("car"));
            assertInstanceOf(BikeVehicle.class, factory.getVehicle("bike"));
        }
    }

    @Test
    void rejectsUnknownVehicleType() {
        try (AnnotationConfigApplicationContext context =
                     new AnnotationConfigApplicationContext(VehicleFactoryConfig.class)) {
            SpringVehicleFactory factory = context.getBean(SpringVehicleFactory.class);

            assertThrows(IllegalArgumentException.class, () -> factory.getVehicle("truck"));
        }
    }
}
