package com.yukta.systemdesign.lld.multithreading.synchronizers.exchanger;

import java.util.concurrent.Exchanger;

public class ExchangerDemo {

    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();

        new Thread(() -> exchange(exchanger, "Order data")).start();
        new Thread(() -> exchange(exchanger, "Invoice data")).start();
    }

    private static void exchange(Exchanger<String> exchanger, String payload) {
        try {
            String received = exchanger.exchange(payload);
            System.out.println(payload + " exchanged for " + received);
        } catch (InterruptedException exception) {
            Thread.currentThread().interrupt();
        }
    }
}
