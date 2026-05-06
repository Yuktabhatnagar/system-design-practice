package com.yukta.systemdesign.lld.softwaredesignprinciples;

public class CompositionOverInheritance {
    public static void main(String[] args) {
        NotificationSenderCoi sender = new NotificationSenderCoi(new SmsChannelCoi());
        sender.send("Order shipped");
    }
}

// Without composition: inheritance creates one class for every variation.
class EmailAlertCoi {
    public void send(String message) {
        System.out.println("Email alert: " + message);
    }
}

class UrgentEmailAlertCoi extends EmailAlertCoi {
    @Override
    public void send(String message) {
        System.out.println("URGENT email alert: " + message);
    }
}

// With composition: behavior is assembled by injecting a channel.
class NotificationSenderCoi {
    private final NotificationChannelCoi channel;

    public NotificationSenderCoi(NotificationChannelCoi channel) {
        this.channel = channel;
    }

    public void send(String message) {
        channel.send(message);
    }
}

interface NotificationChannelCoi {
    void send(String message);
}

class EmailChannelCoi implements NotificationChannelCoi {
    public void send(String message) {
        System.out.println("Email: " + message);
    }
}

class SmsChannelCoi implements NotificationChannelCoi {
    public void send(String message) {
        System.out.println("SMS: " + message);
    }
}
