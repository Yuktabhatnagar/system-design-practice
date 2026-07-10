package com.yukta.systemdesign.lld.interview_problems.parking_lot.interview.domain;

import com.yukta.systemdesign.lld.interview_problems.parking_lot.interview.enums.GateStatus;
import com.yukta.systemdesign.lld.interview_problems.parking_lot.interview.service.PaymentService;
import com.yukta.systemdesign.lld.interview_problems.parking_lot.interview.strategy.fee.FeeStrategy;


import static com.yukta.systemdesign.lld.interview_problems.parking_lot.interview.enums.PaymentStatus.SUCCESS;

public class ExitGate {
    //- receives Ticket
    //-Request fee calculation.-> FeeStrategy
    //-Payment
    //-Release Slot


    private GateStatus status;
    private final FeeStrategy feeStrategy;
    private final PaymentService paymentService;
    private ParkingLot parkingLot;

    public ExitGate(FeeStrategy feeStrategy, PaymentService paymentService, ParkingLot parkingLot) {
        this.feeStrategy = feeStrategy;
        this.paymentService = paymentService;
        this.parkingLot= parkingLot;
    }

    public Receipt processExit(Ticket ticket) {
        double amount= feeStrategy.calculateFee(ticket);
        Receipt receipt=paymentService.makePayment(ticket, amount);
        if(receipt.getStatus().equals(SUCCESS)){
            status= GateStatus.OPEN;
            parkingLot.unparkVehicle(ticket);
            status= GateStatus.CLOSED;
        }
       return receipt;
    }

}
