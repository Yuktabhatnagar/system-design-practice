package com.yukta.systemdesign.lld.multithreading.modern_java_concurrency.asyncprogramming;

import java.util.concurrent.CompletableFuture;

public class ParallelAsyncDemo {

    public static void main(String[] args) {

        CompletableFuture<String> userFuture =
                CompletableFuture.supplyAsync(() -> {

                    sleep(2000);

                    return "Yukta";
                });

        CompletableFuture<String> orderFuture =
                CompletableFuture.supplyAsync(() -> {

                    sleep(3000);

                    return "5 Orders";
                });

        String result =
                userFuture
                        .thenCombine(
                                orderFuture,
                                (user, orders) ->
                                        user + " has " + orders
                        )
                        .join();

        System.out.println(result);
    }

    private static void sleep(int ms) {

        try {
            Thread.sleep(ms);
        } catch (Exception e) {
        }
    }
}
