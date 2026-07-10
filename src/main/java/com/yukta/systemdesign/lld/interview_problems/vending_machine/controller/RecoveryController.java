package com.yukta.systemdesign.lld.interview_problems.vending_machine.controller;
/*
* 5. Power Failure Recovery Use Case:
System startup →
RecoveryController.checkAndRecover() →
RecoveryService.performRecovery() →
Check pending recoveries →
Check last known state →
Execute recovery based on interrupted state →
Reset to safe state (IdleState) →
Mark complete
* */
import com.yukta.systemdesign.lld.interview_problems.vending_machine.domain.Recovery;
import com.yukta.systemdesign.lld.interview_problems.vending_machine.domain.RecoveryStatus;
import com.yukta.systemdesign.lld.interview_problems.vending_machine.domain.state.VendingMachineState;
import com.yukta.systemdesign.lld.interview_problems.vending_machine.service.RecoveryService;

import java.util.List;

public class RecoveryController {
    private RecoveryService recoveryService;

    public RecoveryController(RecoveryService recoveryService) {
        this.recoveryService = recoveryService;
        System.out.println("RecoveryController initialized");
    }

    public void checkAndRecover(int machineId) {
        System.out.println("Controller: Checking and performing recovery for machine " + machineId);
        recoveryService.performRecovery(machineId);
    }

    public RecoveryStatus getRecoveryStatus(int machineId) {
        System.out.println("Controller: Getting recovery status for machine " + machineId);
        return recoveryService.getRecoveryStatus(machineId);
    }

    public void markRecoveryComplete(int machineId, int recoveryId) {
        System.out.println("Controller: Marking recovery " + recoveryId + " as complete for machine " + machineId);
        recoveryService.markRecoveryComplete(machineId, recoveryId);
    }

    public void createRecoveryEntry(int machineId, int transactionId, VendingMachineState state) {
        System.out.println("Controller: Creating recovery entry for machine " + machineId +
                ", transaction " + transactionId + ", state " + state.getStateName());
        recoveryService.createRecoveryEntry(machineId, transactionId, state);
    }

    public List<Recovery> getPendingRecoveries(int machineId) {
        System.out.println("Controller: Getting pending recoveries for machine " + machineId);
        return recoveryService.getPendingRecoveries(machineId);
    }

    /**
     * System startup recovery
     */
    public void checkAndRecover() {
        System.out.println("Controller: Checking and recovering during system startup");
        recoveryService.checkAndRecover();
    }
}

