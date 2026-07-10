package com.yukta.systemdesign.lld.softwaredesignprinciples;

public class FailFastPrinciple {
    public static void main(String[] args) {
        UserRegistrationFfp registration = new UserRegistrationFfp();
        registration.register("raj@example.com", "Raj");
    }
}

class UserRegistrationFfp {
    public void registerBad(String email, String name) {
        System.out.println("Creating user profile");
        System.out.println("Saving user to database");

        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Email is required");
        }

        System.out.println("Sending welcome email to " + email);
    }

    public void register(String email, String name) {
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Email is required");
        }

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name is required");
        }

        System.out.println("Creating user profile for " + name);
        System.out.println("Saving user to database");
        System.out.println("Sending welcome email to " + email);
    }
}
