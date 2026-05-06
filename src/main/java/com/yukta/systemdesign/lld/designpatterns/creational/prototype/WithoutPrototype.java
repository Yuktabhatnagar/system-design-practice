package com.yukta.systemdesign.lld.designpatterns.creational.prototype;

interface EmailTemplate1 {
    void setContent(String content);
    void send(String to);
}

// A concrete email class, hardcoded
class WelcomeEmail1 implements EmailTemplate1 {
    private String subject;
    private String content;

    public WelcomeEmail1() {
        this.subject = "Welcome to TUF+";
        this.content = "Hi there! Thanks for joining us.";
    }

    @Override
    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public void send(String to) {
        System.out.println("Sending to " + to + ": [" + subject + "] " + content);
    }
}

public class WithoutPrototype {
    public static void main(String[] args) {
        // Create a welcome email
        WelcomeEmail1 email1 = new WelcomeEmail1();
        email1.send("user1@example.com");

        // Suppose we want a similar email with slightly different content
        WelcomeEmail1 email2 = new WelcomeEmail1();
        email2.setContent("Hi there! Welcome to TUF Premium.");
        email2.send("user2@example.com");

        // Yet another variation
        WelcomeEmail1 email3 = new WelcomeEmail1();
        email3.setContent("Thanks for signing up. Let's get started!");
        email3.send("user3@example.com");
    }
}

