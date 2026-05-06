package com.yukta.systemdesign.lld.designpatterns.creational.factory;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LogisticsFactoryTest {

    @Test
    void createsLogisticsByMode() {
        assertInstanceOf(Air.class, LogisticsFactory.getLogistics("Air"));
        assertInstanceOf(Road.class, LogisticsFactory.getLogistics("Road"));
    }

    @Test
    void rejectsUnknownLogisticsMode() {
        assertThrows(IllegalArgumentException.class, () -> LogisticsFactory.getLogistics("Ship"));
    }
}
