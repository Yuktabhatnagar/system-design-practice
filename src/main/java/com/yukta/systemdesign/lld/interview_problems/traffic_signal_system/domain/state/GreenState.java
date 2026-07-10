package com.yukta.systemdesign.lld.interview_problems.traffic_signal_system.domain.state;
/*
5. State Pattern Use Cases:
Valid State Transition Use Case:
TrafficLight.turnGreen() → currentState.turnGreen(this) → setState(new GreenState()) → State changed successfully
Invalid State Transition Use Case:
TrafficLight.turnYellow() → currentState.turnYellow(this) → throws InvalidStateTransitionException → Transition blocked
State Query Use Case:
TrafficLight.getCurrentStateName() → currentState.getStateName() → Returns current state name
Emergency State Transition Use Case:
emergencyTransitionToRed() → Check current state → GREEN → YELLOW → RED → YELLOW → RED → RED → (no change) → Log transition sequence
*/


import com.yukta.systemdesign.lld.interview_problems.traffic_signal_system.domain.TrafficLight;

public class GreenState implements TrafficLightState {

    @Override
    public void turnGreen(TrafficLight trafficLight) {
        // No change - already GREEN
        System.out.println("Traffic light " + trafficLight.getDirection() + " is already GREEN");
    }

    @Override
    public void turnYellow(TrafficLight trafficLight) {
        // Valid transition: GREEN → YELLOW
        trafficLight.setState(new YellowState());
        System.out.println("Traffic light " + trafficLight.getDirection() + " changed from GREEN to YELLOW");
    }

    @Override
    public void turnRed(TrafficLight trafficLight) {
        // Invalid transition: GREEN → RED
        throw new InvalidStateTransitionException("GREEN", "RED");
    }

    @Override
    public void turnOff(TrafficLight trafficLight) {
        // Valid transition: GREEN → OFF
        trafficLight.setState(new OffState());
        System.out.println("Traffic light " + trafficLight.getDirection() + " changed from GREEN to OFF");
    }

    @Override
    public String getStateName() {
        return "GREEN";
    }

    @Override
    public boolean canTransitionTo(TrafficLightState newState) {
        return newState instanceof YellowState || newState instanceof OffState;
    }
}
