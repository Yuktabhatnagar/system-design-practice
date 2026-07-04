package com.yukta.systemdesign.lld.api.throttling_ratelimiting;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class RateLimiting {
    public static void main(String[] args) {
        SlidingWindowRateLimiter limiter = new SlidingWindowRateLimiter(3, Duration.ofSeconds(5));
        ApiRateLimitController controller = new ApiRateLimitController(limiter);

        for (int request = 1; request <= 5; request++) {
            System.out.println(controller.handle("user-1", "/orders"));
        }
    }
}

class ApiRateLimitController {
    private final SlidingWindowRateLimiter limiter;

    ApiRateLimitController(SlidingWindowRateLimiter limiter) {
        this.limiter = limiter;
    }

    RateLimitResponse handle(String clientId, String path) {
        if (!limiter.allow(clientId)) {
            return new RateLimitResponse(429, "Too many requests for " + clientId);
        }

        return new RateLimitResponse(200, "Handled " + path + " for " + clientId);
    }
}

class SlidingWindowRateLimiter {
    private final int maxRequests;
    private final Duration window;
    private final Map<String, Deque<Instant>> requestLog = new HashMap<>();

    SlidingWindowRateLimiter(int maxRequests, Duration window) {
        this.maxRequests = maxRequests;
        this.window = window;
    }

    boolean allow(String clientId) {
        Instant now = Instant.now();
        Deque<Instant> timestamps = requestLog.computeIfAbsent(clientId, key -> new ArrayDeque<>());

        while (!timestamps.isEmpty() && timestamps.peekFirst().plus(window).isBefore(now)) {
            timestamps.removeFirst();
        }

        if (timestamps.size() >= maxRequests) {
            return false;
        }

        timestamps.addLast(now);
        return true;
    }
}

record RateLimitResponse(int statusCode, String message) {
}