package com.yukta.systemdesign.lld.api.throttling_ratelimiting;

import java.time.Duration;
import java.time.Instant;

public class Throttling {
    public static void main(String[] args) throws InterruptedException {
        ApiThrottler throttler = new ApiThrottler(Duration.ofMillis(500));
        ApiThrottlingController controller = new ApiThrottlingController(throttler);

        for (int request = 1; request <= 4; request++) {
            System.out.println(controller.handle("request-" + request));
        }
    }
}

class ApiThrottlingController {
    private final ApiThrottler throttler;

    ApiThrottlingController(ApiThrottler throttler) {
        this.throttler = throttler;
    }

    ThrottlingResponse handle(String requestId) throws InterruptedException {
        throttler.waitForTurn();
        return new ThrottlingResponse(200, "Processed " + requestId + " at " + Instant.now());
    }
}

class ApiThrottler {
    private final Duration minimumGap;
    private Instant nextAllowedTime = Instant.now();

    ApiThrottler(Duration minimumGap) {
        this.minimumGap = minimumGap;
    }

    synchronized void waitForTurn() throws InterruptedException {
        Instant now = Instant.now();

        if (now.isBefore(nextAllowedTime)) {
            long waitMillis = Duration.between(now, nextAllowedTime).toMillis();
            Thread.sleep(waitMillis);
        }

        nextAllowedTime = Instant.now().plus(minimumGap);
    }
}

record ThrottlingResponse(int statusCode, String message) {
}