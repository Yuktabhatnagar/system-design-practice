package com.yukta.systemdesign.hld.high_design_patterns.marker_interface;

public class MarkerInterfaceDemo {
    public static void main(String[] args) {
        AuditService auditService = new AuditService();
        auditService.audit(new PaymentEvent("payment-1"));
        auditService.audit(new InternalEvent("cache-refresh"));
    }
}

interface Auditable {}
record PaymentEvent(String id) implements Auditable {}
record InternalEvent(String name) {}
class AuditService {
    void audit(Object event) {
        if (event instanceof Auditable) { System.out.println("Audited event: " + event); }
        else { System.out.println("Skipped non-auditable event: " + event); }
    }
}
