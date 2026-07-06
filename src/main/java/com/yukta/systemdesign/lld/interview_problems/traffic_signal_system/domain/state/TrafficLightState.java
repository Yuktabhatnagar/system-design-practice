package com.yukta.systemdesign.lld.interview_problems.traffic_signal_system.domain.state;


import com.yukta.systemdesign.lld.interview_problems.traffic_signal_system.domain.TrafficLight;

public interface TrafficLightState {
    void turnGreen(TrafficLight trafficLight);
    void turnYellow(TrafficLight trafficLight);
    void turnRed(TrafficLight trafficLight);
    void turnOff(TrafficLight trafficLight);
    String getStateName();
    boolean canTransitionTo(TrafficLightState newState);
}