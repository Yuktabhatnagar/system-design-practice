package com.yukta.systemdesign.lld.multithreading.modern_java_concurrency.asyncprogramming;

import java.util.concurrent.CompletableFuture;

public class FireAndForget {

    public static void main(String[] args) {

        CompletableFuture.runAsync(() -> {

            System.out.println(
                    "Sending Email..."
            );
        });

        System.out.println(
                "Request completed"
        );

        try {
            Thread.sleep(1000);
        } catch (Exception e) {
        }
    }
}
