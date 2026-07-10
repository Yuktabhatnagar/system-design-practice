package com.yukta.systemdesign.lld.interview_problems.logging_framework_cor.core;

public abstract class LogHandler {
    private LogHandler nextHandler;

    public LogHandler setNext(LogHandler nextHandler) {
        this.nextHandler = nextHandler;
        return nextHandler;
    }

    public final void handle(LogMessage logMessage) {
        if (canHandle(logMessage.getLevel())) {
            write(logMessage);
            return;
        }

        if (nextHandler != null) {
            nextHandler.handle(logMessage);
        } else {
            System.out.println("No handler found for level: " + logMessage.getLevel());
        }
    }

    protected abstract boolean canHandle(LogLevel level);

    protected abstract void write(LogMessage logMessage);

    protected String format(LogMessage logMessage) {
        return String.format("[%s] %s - %s",
                logMessage.getLevel(),
                logMessage.getTimestamp(),
                logMessage.getMessage());
    }
}
