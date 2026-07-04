package com.yukta.systemdesign.lld.api.types.websocket;

public class WebSocketApiDemo {
    public static void main(String[] args) {
        WebSocketSession session = new WebSocketSession("client-1");
        session.connect();
        session.send("price-update:100");
        session.disconnect();
    }
}

class WebSocketSession {
    private final String clientId;
    private boolean connected;
    WebSocketSession(String clientId) { this.clientId = clientId; }
    void connect() { connected = true; System.out.println(clientId + " connected"); }
    void send(String message) {
        if (!connected) { throw new IllegalStateException("Client is not connected"); }
        System.out.println("Sent to " + clientId + ": " + message);
    }
    void disconnect() { connected = false; System.out.println(clientId + " disconnected"); }
}
