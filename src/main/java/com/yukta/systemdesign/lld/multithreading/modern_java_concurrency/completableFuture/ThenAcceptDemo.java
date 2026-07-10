package com.yukta.systemdesign.lld.multithreading.modern_java_concurrency.completablefuture;

import java.util.concurrent.CompletableFuture;

public class ThenAcceptDemo {

    public static void main(String[] args) {

        CompletableFuture
                .supplyAsync(() -> "Yukta")

                .thenAccept(name ->
                        System.out.println("Hello " + name)
                );

        try {
            Thread.sleep(1000);
        } catch (Exception e) {
        }
    }
}
