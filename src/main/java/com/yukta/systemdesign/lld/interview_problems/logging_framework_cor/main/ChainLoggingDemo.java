package com.yukta.systemdesign.lld.interview_problems.logging_framework_cor.main;

import com.yukta.systemdesign.lld.interview_problems.logging_framework_cor.core.ChainLogger;
import com.yukta.systemdesign.lld.interview_problems.logging_framework_cor.core.LogHandler;
import com.yukta.systemdesign.lld.interview_problems.logging_framework_cor.handlers.DebugLogHandler;
import com.yukta.systemdesign.lld.interview_problems.logging_framework_cor.handlers.ErrorLogHandler;
import com.yukta.systemdesign.lld.interview_problems.logging_framework_cor.handlers.FatalLogHandler;
import com.yukta.systemdesign.lld.interview_problems.logging_framework_cor.handlers.InfoLogHandler;
import com.yukta.systemdesign.lld.interview_problems.logging_framework_cor.handlers.WarningLogHandler;

public class ChainLoggingDemo {
    public static void main(String[] args) {
        LogHandler debugHandler = new DebugLogHandler();

        debugHandler
                .setNext(new InfoLogHandler())
                .setNext(new WarningLogHandler())
                .setNext(new ErrorLogHandler())
                .setNext(new FatalLogHandler());

        ChainLogger logger = new ChainLogger(debugHandler);

        logger.debug("Debugging application flow");
        logger.info("Application started");
        logger.warning("Memory usage is high");
        logger.error("Payment service failed");
        logger.fatal("System cannot recover");
    }
}
