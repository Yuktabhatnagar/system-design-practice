package com.yukta.systemdesign.hld.high_design_patterns.strangler_fig;

public class StranglerFigDemo {
    public static void main(String[] args) {
        MigrationRouter router = new MigrationRouter(new LegacyOrderService(), new NewOrderService());
        System.out.println(router.route("legacy-101"));
        System.out.println(router.route("new-202"));
    }
}

class MigrationRouter {
    private final LegacyOrderService legacyService;
    private final NewOrderService newService;
    MigrationRouter(LegacyOrderService legacyService, NewOrderService newService) { this.legacyService = legacyService; this.newService = newService; }
    String route(String orderId) { return orderId.startsWith("new") ? newService.getOrder(orderId) : legacyService.getOrder(orderId); }
}
class LegacyOrderService { String getOrder(String orderId) { return "Legacy service returned " + orderId; } }
class NewOrderService { String getOrder(String orderId) { return "New service returned " + orderId; } }
