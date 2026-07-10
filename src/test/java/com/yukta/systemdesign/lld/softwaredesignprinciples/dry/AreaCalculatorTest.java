package com.yukta.systemdesign.lld.softwaredesignprinciples.dry;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AreaCalculatorTest {

    @Test
    void calculatesRectangleArea() {
        assertEquals(50, AreaCalculator.calculateArea(10, 5));
        assertEquals(32, AreaCalculator.calculateArea(8, 4));
    }
}
