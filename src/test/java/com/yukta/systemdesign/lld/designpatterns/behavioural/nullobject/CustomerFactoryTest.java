package com.yukta.systemdesign.lld.designpatterns.behavioural.nullobject;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CustomerFactoryTest {

    @Test
    void returnsRealCustomerForKnownUser() {
        Customer customer = CustomerFactory.getCustomer("Yukta");

        assertNotNull(customer);
        assertEquals("Yukta", customer.getName());
        assertFalse(customer.isNull());
    }

    @Test
    void returnsNullCustomerForUnknownUser() {
        Customer customer = CustomerFactory.getCustomer("Unknown");

        assertNotNull(customer);
        assertEquals("Guest User", customer.getName());
        assertTrue(customer.isNull());
    }
}
