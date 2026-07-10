package com.yukta.systemdesign.lld.interview_problems.logging_framework_cor.core;

import java.time.Instant;

public class LogMessage {
    private final LogLevel level;
    private final String message;
    private final Instant timestamp;

    public LogMessage(LogLevel level, String message) {
        if (level == null) {
            throw new IllegalArgumentException("Log level is required");
        }
        if (message == null || message.trim().isEmpty()) {
            throw new IllegalArgumentException("Message is required");
        }
        this.level = level;
        this.message = message;
        this.timestamp = Instant.now();
    }

    public LogLevel getLevel() {
        return level;
    }

    public String getMessage() {
        return message;
    }

    public Instant getTimestamp() {
        return timestamp;
    }
}
