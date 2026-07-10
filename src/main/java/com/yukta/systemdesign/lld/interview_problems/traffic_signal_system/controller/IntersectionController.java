package com.yukta.systemdesign.lld.interview_problems.traffic_signal_system.controller;

/*
1. IntersectionController Use Cases:
Intersection Creation Use Case:
createIntersection() → IntersectionService.createIntersection() → IntersectionRepository.save() → Intersection created with 4 traffic lights and default timings
Intersection Status Use Case:
getIntersection() → IntersectionService.getIntersection() → IntersectionRepository.findById() → Intersection with all traffic light states and timings returned
Automatic Cycle Use Case:
startCycle() → IntersectionService.startAutomaticCycle() → Timer schedules cycle with configurable durations → Automatic cycling begins
Cycle Pause/Resume Use Case:
EmergencyService.requestEmergency() → IntersectionService.pauseCycle() → Cycle paused at current phase → EmergencyService.endEmergency() → IntersectionService.resumeCycle() → Cycle resumes from paused phase
Emergency Request Use Case:
requestEmergency() → EmergencyService.requestEmergency() → IntersectionService.pauseCycle() → IntersectionService.emergencySetAllSignalsToRed() → Emergency direction GREEN → Timer for resume
*/
import com.yukta.systemdesign.lld.interview_problems.traffic_signal_system.domain.Direction;
import com.yukta.systemdesign.lld.interview_problems.traffic_signal_system.domain.Intersection;
import com.yukta.systemdesign.lld.interview_problems.traffic_signal_system.domain.IntersectionCycle;
import com.yukta.systemdesign.lld.interview_problems.traffic_signal_system.domain.TrafficLight;
import com.yukta.systemdesign.lld.interview_problems.traffic_signal_system.service.IntersectionService;

public class IntersectionController {
    private IntersectionService intersectionService;

    public IntersectionController(IntersectionService intersectionService) {
        this.intersectionService = intersectionService;
        System.out.println("IntersectionController initialized");
    }

    public void createIntersection(int id, String name) {
        System.out.println("Creating intersection: " + name + " (ID: " + id + ")");
        intersectionService.createIntersection(id, name);
    }

    public Intersection getIntersection(int intersectionId) {
        System.out.println("Getting intersection: " + intersectionId);
        return intersectionService.getIntersection(intersectionId);
    }

    public void startCycle(int intersectionId) {
        System.out.println("Starting cycle for intersection: " + intersectionId);
        intersectionService.startAutomaticCycle(intersectionId);
    }

    public void displayStatus(int intersectionId) {
        System.out.println("Displaying status for intersection: " + intersectionId);
        Intersection intersection = intersectionService.getIntersection(intersectionId);
        if (intersection != null) {
            System.out.println("=== Intersection Status ===");
            System.out.println("ID: " + intersection.getId());
            System.out.println("Name: " + intersection.getName());
            System.out.println("Emergency Mode: " + intersection.isEmergencyMode());
            System.out.println("Cycle Paused: " + intersection.isCyclePaused());
            System.out.println("Paused Phase: " + intersectionService.getPausedPhase(intersectionId));

            System.out.println("Traffic Light States:");
            for (Direction direction : Direction.values()) {
                TrafficLight light = intersection.getTrafficLight(direction);
                System.out.println("  " + direction + ": " + light.getCurrentStateName());
            }

            IntersectionCycle cycle = intersectionService.getCycle(intersectionId);
            if (cycle != null) {
                System.out.println("Current Phase: " + cycle.getCurrentPhase());
                System.out.println("Phase Start Time: " + cycle.getPhaseStartTime());
            }
            System.out.println("========================");
        } else {
            System.out.println("Intersection not found: " + intersectionId);
        }
    }
}
