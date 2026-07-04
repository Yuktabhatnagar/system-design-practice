package com.yukta.systemdesign.lld.high_design_patterns.sidecar_pattern;

public class SidecarPatternDemo {
    public static void main(String[] args) {
        new AppService(new LoggingSidecar()).handle("create-order");
    }
}

class AppService {
    private final Sidecar sidecar;
    AppService(Sidecar sidecar) { this.sidecar = sidecar; }
    void handle(String request) {
        sidecar.before(request);
        System.out.println("App handled request: " + request);
        sidecar.after(request);
    }
}
interface Sidecar { void before(String request); void after(String request); }
class LoggingSidecar implements Sidecar {
    public void before(String request) { System.out.println("Sidecar start: " + request); }
    public void after(String request) { System.out.println("Sidecar end: " + request); }
}
