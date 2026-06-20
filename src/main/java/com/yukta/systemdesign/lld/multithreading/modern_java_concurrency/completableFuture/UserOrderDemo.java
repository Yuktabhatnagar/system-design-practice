package com.yukta.systemdesign.lld.multithreading.modern_java_concurrency.completablefuture;

import java.util.concurrent.CompletableFuture;

public class UserOrderDemo {

    public static void main(String[] args) {
        /*Without Parallelism
        2 sec + 3 sec = 5 sec

        With CompletableFuture
        max(2,3) = 3 sec

        Both tasks execute concurrently.*/
        CompletableFuture<String> user =
                CompletableFuture.supplyAsync(() -> {

                    sleep(2000);

                    return "Yukta";
                });

        CompletableFuture<String> orders =
                CompletableFuture.supplyAsync(() -> {

                    sleep(3000);

                    return "5 Orders";
                });

        CompletableFuture<String> result =
                user.thenCombine(
                        orders,
                        (u, o) -> u + " has " + o
                );

        System.out.println(result.join());
    }

    private static void sleep(int ms) {

        try {
            Thread.sleep(ms);
        } catch (Exception e) {
        }
    }
}
