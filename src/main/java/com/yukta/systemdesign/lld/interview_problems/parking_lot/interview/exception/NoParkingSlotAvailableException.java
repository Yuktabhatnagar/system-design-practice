package com.yukta.systemdesign.lld.interview_problems.parking_lot.interview.exception;

public class NoParkingSlotAvailableException extends Throwable {
    public NoParkingSlotAvailableException(String message) {
        super(message);
    }
}
