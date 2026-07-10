package com.yukta.systemdesign.lld.interview_problems.parking_lot.interview.Main;

import com.yukta.systemdesign.lld.interview_problems.parking_lot.interview.domain.*;
import com.yukta.systemdesign.lld.interview_problems.parking_lot.interview.enums.GateStatus;
import com.yukta.systemdesign.lld.interview_problems.parking_lot.interview.enums.VehicleType;
import com.yukta.systemdesign.lld.interview_problems.parking_lot.interview.exception.NoParkingSlotAvailableException;
import com.yukta.systemdesign.lld.interview_problems.parking_lot.interview.service.PaymentService;
import com.yukta.systemdesign.lld.interview_problems.parking_lot.interview.service.TicketService;
import com.yukta.systemdesign.lld.interview_problems.parking_lot.interview.strategy.fee.HourlyFeeStrategy;
import com.yukta.systemdesign.lld.interview_problems.parking_lot.interview.strategy.parking.FirstAvailableStrategy;
import com.yukta.systemdesign.lld.interview_problems.parking_lot.interview.strategy.parking.NearestStrategy;
import com.yukta.systemdesign.lld.interview_problems.parking_lot.interview.strategy.payment.UPIPayment;

import java.util.ArrayList;
import java.util.List;

//Create a ParkingLot.
//Add floors.
//Add parking slots.
//Configure strategies and services.
//Create a vehicle.
//Enter through EntryGate.
//Generate a ticket.
//Exit through ExitGate.
//Calculate the fee.
//Process payment.
//Generate the receipt.
public class Main {
    public static void main(String[] args){
        List<ParkingFloor> parkingFloors = new ArrayList<>();
        ParkingFloor floor1 = new ParkingFloor(1, new FirstAvailableStrategy());
        ParkingFloor floor2 = new ParkingFloor(2, new NearestStrategy());
        ParkingSlot slot1 = new ParkingSlot(VehicleType.BIKE, floor1);
        ParkingSlot slot2 = new ParkingSlot(VehicleType.CAR, floor1);
        ParkingSlot slot3 = new ParkingSlot(VehicleType.TRUCK, floor1);
        ParkingSlot slot4 = new ParkingSlot(VehicleType.BIKE, floor2);
        floor1.addSlot(slot1);
        floor1.addSlot(slot2);
        floor1.addSlot(slot3);
        floor2.addSlot(slot4);
        parkingFloors.add(floor1);
        parkingFloors.add(floor2);
        List<ExitGate> exitGates = new ArrayList<>();
        List<EntryGate> entryGates = new ArrayList<>();
        TicketService ticketService= new TicketService();
        ParkingLot parkingLot = new ParkingLot(parkingFloors, entryGates, exitGates, ticketService);
        PaymentService service= new PaymentService(new UPIPayment());
        EntryGate entryGate = new EntryGate(parkingLot, GateStatus.CLOSED);
        entryGates.add(entryGate);
        ExitGate exitGate = new ExitGate(new HourlyFeeStrategy(),service, parkingLot);
        exitGates.add(exitGate);
        Vehicle vehicle = new Bike("UP80DC5668");
        System.out.println(floor1.getParkingSlots().size());

        for (ParkingSlot slot : floor1.getParkingSlots()) {
            System.out.println("Available: " + slot.isAvailable());
            System.out.println("Can Park: " + slot.canPark(vehicle));
        }
        Ticket ticket = entryGate.enterVehicle(vehicle);
        System.out.println("Vehicle : "
                + vehicle.getVehicleNumber());
        ticket.setExitTime(ticket.getEntryTime().plusHours(3));
        System.out.println("Slot : "
                + ticket.getParkingSlot());
        System.out.println("Entry Time : "
                + ticket.getEntryTime());

        System.out.println("Exit Time : "
                + ticket.getExitTime());
        Receipt receipt= exitGate.processExit(ticket);
        System.out.println("Amount : "
                + receipt.getAmount());

        System.out.println("Payment Status : "
                + receipt.getStatus());
    }
}
