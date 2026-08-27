package com.yukta.systemdesign.hld.high_design_patterns.hexagonal_architecture;

public class HexagonalArchitectureDemo {
    public static void main(String[] args) {
        OrderPort orderPort = new OrderService(new ConsoleNotificationAdapter());
        new OrderHttpAdapter(orderPort).postOrder("order-1");
    }
}

interface OrderPort { void placeOrder(String orderId); }
interface NotificationPort { void notify(String message); }
class OrderService implements OrderPort {
    private final NotificationPort notificationPort;
    OrderService(NotificationPort notificationPort) { this.notificationPort = notificationPort; }
    public void placeOrder(String orderId) { notificationPort.notify("Order placed: " + orderId); }
}
class ConsoleNotificationAdapter implements NotificationPort { public void notify(String message) { System.out.println(message); } }
class OrderHttpAdapter {
    private final OrderPort orderPort;
    OrderHttpAdapter(OrderPort orderPort) { this.orderPort = orderPort; }
    void postOrder(String orderId) { orderPort.placeOrder(orderId); }
}
