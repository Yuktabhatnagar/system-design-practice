package com.yukta.systemdesign.hld.high_design_patterns.dependency_injection_pattern;

public class DependencyInjectionPatternDemo {

    public static void main(String[] args) {
        MessageSender sender = new ConsoleMessageSender();
        NotificationService service = new NotificationService(sender);

        service.notify("Order shipped");
    }
}

interface MessageSender {
    void send(String message);
}

class ConsoleMessageSender implements MessageSender {

    @Override
    public void send(String message) {
        System.out.println(message);
    }
}

class NotificationService {

    private final MessageSender sender;

    NotificationService(MessageSender sender) {
        this.sender = sender;
    }

    void notify(String message) {
        sender.send(message);
    }
}
