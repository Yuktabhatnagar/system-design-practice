package com.yukta.systemdesign.lld.designpatterns.behavioural.template;

// EmailNotification handles sending emails
class EmailNotification {

    public void send(String to, String message) {
        System.out.println("Checking rate limits for: " + to);
        System.out.println("Validating email recipient: " + to);
        String formatted = message.trim();
        System.out.println("Logging before send: " + formatted + " to " + to);

        // Compose Email
        String composedMessage = "<html><body><p>" + formatted + "</p></body></html>";

        // Send Email
        System.out.println("Sending EMAIL to " + to + " with content:\n" + composedMessage);

        // Analytics
        System.out.println("Analytics updated for: " + to);
    }
}

// SMSNotification handles sending SMS messages
class SMSNotification {

    public void send(String to, String message) {
        System.out.println("Checking rate limits for: " + to);
        System.out.println("Validating phone number: " + to);
        String formatted = message.trim();
        System.out.println("Logging before send: " + formatted + " to " + to);

        // Compose SMS
        String composedMessage = "[SMS] " + formatted;

        // Send SMS
        System.out.println("Sending SMS to " + to + " with message: " + composedMessage);

        // Analytics (custom)
        System.out.println("Custom SMS analytics for: " + to);
    }
}

public class WithoutTemplate {
    public static void main(String[] args) {
        // Create objects for both notification services
        EmailNotification1 emailNotification = new EmailNotification1();
        SMSNotification1 smsNotification = new SMSNotification1();

        // Sending email notification
        emailNotification.send("example@example.com", "Your order has been placed!");

        System.out.println(" ");

        // Sending SMS notification
        smsNotification.send("1234567890", "Your OTP is 1234.");
    }
}
