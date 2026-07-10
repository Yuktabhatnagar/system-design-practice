package com.yukta.systemdesign.lld.interview_problems.logging_framework_cor.handlers;

import com.yukta.systemdesign.lld.interview_problems.logging_framework_cor.core.LogHandler;
import com.yukta.systemdesign.lld.interview_problems.logging_framework_cor.core.LogLevel;
import com.yukta.systemdesign.lld.interview_problems.logging_framework_cor.core.LogMessage;

public class WarningLogHandler extends LogHandler {
    @Override
    protected boolean canHandle(LogLevel level) {
        return level == LogLevel.WARNING;
    }

    @Override
    protected void write(LogMessage logMessage) {
        System.out.println("WarningLogHandler handled: " + format(logMessage));
    }
}
