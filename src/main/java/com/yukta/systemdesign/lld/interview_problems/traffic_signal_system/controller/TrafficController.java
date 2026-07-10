package com.yukta.systemdesign.lld.interview_problems.traffic_signal_system.controller;

/*
3. TrafficController Use Cases:
Vehicle Count Update Use Case:
updateVehicleCount() → TrafficService.updateVehicleCount() → TrafficRepository.updateCount() → Count updated → Trigger dynamic timing adjustment if enabled
Vehicle Count Query Use Case:
getVehicleCount() → TrafficService.getVehicleCount() → TrafficRepository.getCount() → Count returned
Dynamic Timing Trigger Use Case:
updateVehicleCount() → TrafficService.updateVehicleCount() → TrafficRepository.updateCount() → TimingService.adjustTimingBasedOnTraffic() → TimingRepository.updateSignalTiming() → Dynamic timing applied
*/
import com.yukta.systemdesign.lld.interview_problems.traffic_signal_system.domain.Direction;
import com.yukta.systemdesign.lld.interview_problems.traffic_signal_system.service.TrafficService;

public class TrafficController {
    private TrafficService trafficService;

    public TrafficController(TrafficService trafficService) {
        this.trafficService = trafficService;
        System.out.println("TrafficController initialized");
    }

    public void updateVehicleCount(Direction direction, int count) {
        System.out.println("Updating vehicle count for " + direction + ": " + count);
        trafficService.updateVehicleCount(direction, count);
    }

    public int getVehicleCount(Direction direction) {
        System.out.println("Getting vehicle count for " + direction);
        return trafficService.getVehicleCount(direction);
    }

    public void incrementVehicleCount(Direction direction) {
        System.out.println("Incrementing vehicle count for " + direction);
        trafficService.incrementVehicleCount(direction);
    }

    public void resetVehicleCount(Direction direction) {
        System.out.println("Resetting vehicle count for " + direction);
        trafficService.resetVehicleCount(direction);
    }

    public void displayTrafficStatus() {
        System.out.println("=== Traffic Status ===");
        for (Direction direction : Direction.values()) {
            int count = trafficService.getVehicleCount(direction);
            System.out.println(direction + ": " + count + " vehicles");
        }
        System.out.println("=====================");
    }

    public void detectTrafficConditions() {
        System.out.println("Detecting traffic conditions for all directions");
        for (Direction direction : Direction.values()) {
            trafficService.detectTrafficCondition(direction);
        }
    }
}
