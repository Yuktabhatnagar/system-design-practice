package com.yukta.systemdesign.lld.high_design_patterns.circuit_breaker;

import java.util.function.Supplier;

public class CircuitBreakerDemo {
    public static void main(String[] args) {
        CircuitBreaker breaker = new CircuitBreaker(2);
        RemotePaymentService service = new RemotePaymentService();
        call(breaker, () -> service.pay(true));
        call(breaker, () -> service.pay(true));
        call(breaker, () -> service.pay(false));
    }

    private static void call(CircuitBreaker breaker, Supplier<String> supplier) {
        try {
            System.out.println(breaker.execute(supplier));
        } catch (RuntimeException exception) {
            System.out.println(exception.getMessage() + " | state=" + breaker.state());
        }
    }
}

enum CircuitState { CLOSED, OPEN }

class CircuitBreaker {
    private final int failureThreshold;
    private int failures;
    private CircuitState state = CircuitState.CLOSED;

    CircuitBreaker(int failureThreshold) {
        this.failureThreshold = failureThreshold;
    }

    <T> T execute(Supplier<T> operation) {
        if (state == CircuitState.OPEN) {
            throw new IllegalStateException("Circuit is open");
        }
        try {
            T result = operation.get();
            failures = 0;
            return result;
        } catch (RuntimeException exception) {
            failures++;
            if (failures >= failureThreshold) {
                state = CircuitState.OPEN;
            }
            throw exception;
        }
    }

    CircuitState state() { return state; }
}

class RemotePaymentService {
    String pay(boolean fail) {
        if (fail) {
            throw new IllegalStateException("Payment service timeout");
        }
        return "Payment successful";
    }
}
