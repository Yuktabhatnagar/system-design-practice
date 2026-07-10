package com.yukta.systemdesign.lld.interview_problems.parking_lot.interview.domain;

import com.yukta.systemdesign.lld.interview_problems.parking_lot.interview.enums.VehicleType;

public class Car extends Vehicle {
    public Car(String vehicleNumber) {
        super(vehicleNumber, VehicleType.CAR);
    }
}
