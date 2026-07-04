package com.yukta.systemdesign.lld.api.types.rpc;

public class RpcDemo {
    public static void main(String[] args) {
        CalculatorRpcService service = new CalculatorRpcService();
        System.out.println(service.call("add", 10, 20));
    }
}

class CalculatorRpcService {
    int call(String method, int left, int right) {
        if ("add".equals(method)) { return left + right; }
        throw new IllegalArgumentException("Unknown RPC method: " + method);
    }
}
