package com.yukta.systemdesign.lld.interview_problems.logging_framework_cor.core;

public class ChainLogger {
    private final LogHandler firstHandler;

    public ChainLogger(LogHandler firstHandler) {
        if (firstHandler == null) {
            throw new IllegalArgumentException("First handler is required");
        }
        this.firstHandler = firstHandler;
    }

    public void debug(String message) {
        log(LogLevel.DEBUG, message);
    }

    public void info(String message) {
        log(LogLevel.INFO, message);
    }

    public void warning(String message) {
        log(LogLevel.WARNING, message);
    }

    public void error(String message) {
        log(LogLevel.ERROR, message);
    }

    public void fatal(String message) {
        log(LogLevel.FATAL, message);
    }

    public void log(LogLevel level, String message) {
        firstHandler.handle(new LogMessage(level, message));
    }
}
