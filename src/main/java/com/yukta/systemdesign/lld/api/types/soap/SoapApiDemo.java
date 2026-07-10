package com.yukta.systemdesign.lld.api.types.soap;

public class SoapApiDemo {
    public static void main(String[] args) {
        SoapClient client = new SoapClient();
        System.out.println(client.wrap("GetUser", "<id>1</id>"));
    }
}

class SoapClient {
    String wrap(String action, String body) {
        return "<Envelope><Action>" + action + "</Action><Body>" + body + "</Body></Envelope>";
    }
}
