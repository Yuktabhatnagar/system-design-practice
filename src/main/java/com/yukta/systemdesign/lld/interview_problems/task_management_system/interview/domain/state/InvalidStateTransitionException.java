package com.yukta.systemdesign.lld.interview_problems.task_management_system.interview.domain.state;


public class InvalidStateTransitionException extends RuntimeException {

    public InvalidStateTransitionException(String message) {
        super(message);
    }

    public InvalidStateTransitionException(String message, Throwable cause) {
        super(message, cause);
    }
}


