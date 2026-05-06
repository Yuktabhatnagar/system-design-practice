package com.yukta.systemdesign.lld.designpatterns.behavioural.statepattern;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OrderContextTest {

    @Test
    void movesOrderThroughHappyPathStates() {
        OrderContext order = new OrderContext();

        assertEquals("ORDER_PLACED", order.getCurrentState());

        order.next();
        assertEquals("PREPARING", order.getCurrentState());

        order.next();
        assertEquals("OUT_FOR_DELIVERY", order.getCurrentState());

        order.next();
        assertEquals("DELIVERED", order.getCurrentState());
    }

    @Test
    void cancelsBeforeOrderIsOutForDelivery() {
        OrderContext order = new OrderContext();

        order.cancel();

        assertEquals("CANCELLED", order.getCurrentState());
    }

    @Test
    void doesNotCancelOutForDeliveryOrder() {
        OrderContext order = new OrderContext();
        order.next();
        order.next();

        order.cancel();

        assertEquals("OUT_FOR_DELIVERY", order.getCurrentState());
    }
}
