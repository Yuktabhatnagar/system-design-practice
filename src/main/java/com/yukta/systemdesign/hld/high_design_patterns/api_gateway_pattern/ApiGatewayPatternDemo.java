package com.yukta.systemdesign.hld.high_design_patterns.api_gateway_pattern;

import java.util.HashMap;
import java.util.Map;

public class ApiGatewayPatternDemo {
    public static void main(String[] args) {
        ApiGateway gateway = new ApiGateway();
        System.out.println(gateway.route("/users/1"));
        System.out.println(gateway.route("/orders/9"));
    }
}

class ApiGateway {
    private final Map<String, BackendService> routes = new HashMap<>();
    ApiGateway() {
        routes.put("/users", new UserBackendService());
        routes.put("/orders", new OrderBackendService());
    }
    String route(String path) {
        return routes.entrySet().stream()
                .filter(entry -> path.startsWith(entry.getKey()))
                .findFirst()
                .map(entry -> entry.getValue().handle(path))
                .orElse("404 route not found: " + path);
    }
}

interface BackendService { String handle(String path); }
class UserBackendService implements BackendService { public String handle(String path) { return "User service handled " + path; } }
class OrderBackendService implements BackendService { public String handle(String path) { return "Order service handled " + path; } }
