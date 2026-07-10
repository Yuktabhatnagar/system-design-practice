package com.yukta.systemdesign.lld.solid.isp;

public class Uber {
    public static void main(String[] args) {
        RiderActions rider = new Rider();
        DriverActions driver = new Driver();
        AdminActions admin = new Admin();

        rider.bookRide("MG Road");
        driver.acceptRide("ride-101");
        admin.blockUser("user-55");
    }
}

// Without ISP: one fat interface forces every user type to know unrelated actions.
interface UberUser {
    void bookRide(String destination);

    void acceptRide(String rideId);

    void blockUser(String userId);
}

class RiderWithoutIsp implements UberUser {
    @Override
    public void bookRide(String destination) {
        System.out.println("Booking ride to " + destination);
    }

    @Override
    public void acceptRide(String rideId) {
        throw new UnsupportedOperationException("Rider cannot accept rides");
    }

    @Override
    public void blockUser(String userId) {
        throw new UnsupportedOperationException("Rider cannot block users");
    }
}

// With ISP: clients depend only on the actions they actually use.
interface RiderActions {
    void bookRide(String destination);
}

interface DriverActions {
    void acceptRide(String rideId);
}

interface AdminActions {
    void blockUser(String userId);
}

class Rider implements RiderActions {
    @Override
    public void bookRide(String destination) {
        System.out.println("Booking ride to " + destination);
    }
}

class Driver implements DriverActions {
    @Override
    public void acceptRide(String rideId) {
        System.out.println("Driver accepted ride " + rideId);
    }
}

class Admin implements AdminActions {
    @Override
    public void blockUser(String userId) {
        System.out.println("Blocked user " + userId);
    }
}
