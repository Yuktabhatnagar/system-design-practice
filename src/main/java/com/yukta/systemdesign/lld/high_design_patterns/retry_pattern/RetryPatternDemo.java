package com.yukta.systemdesign.lld.high_design_patterns.retry_pattern;

import java.util.function.Supplier;

public class RetryPatternDemo {
    public static void main(String[] args) {
        RetryExecutor retryExecutor = new RetryExecutor(3);
        UnstableClient client = new UnstableClient(2);
        System.out.println(retryExecutor.execute(client::fetchData));
    }
}

class RetryExecutor {
    private final int maxAttempts;
    RetryExecutor(int maxAttempts) { this.maxAttempts = maxAttempts; }
    <T> T execute(Supplier<T> operation) {
        RuntimeException lastError = null;
        for (int attempt = 1; attempt <= maxAttempts; attempt++) {
            try { return operation.get(); }
            catch (RuntimeException exception) {
                lastError = exception;
                System.out.println("Attempt " + attempt + " failed: " + exception.getMessage());
            }
        }
        throw lastError;
    }
}

class UnstableClient {
    private int failuresBeforeSuccess;
    UnstableClient(int failuresBeforeSuccess) { this.failuresBeforeSuccess = failuresBeforeSuccess; }
    String fetchData() {
        if (failuresBeforeSuccess > 0) {
            failuresBeforeSuccess--;
            throw new IllegalStateException("Temporary network issue");
        }
        return "Data fetched";
    }
}
