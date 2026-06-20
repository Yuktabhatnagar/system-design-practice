package com.yukta.systemdesign.lld.multithreading.modern_java_concurrency.asyncprogramming;

import java.util.concurrent.CompletableFuture;

public class AllOfDemo {

    public static void main(String[] args) {

        CompletableFuture<Void> f1 =
                CompletableFuture.runAsync(() -> {
                    sleep(2000);
                    System.out.println("Task 1");
                });

        CompletableFuture<Void> f2 =
                CompletableFuture.runAsync(() -> {
                    sleep(3000);
                    System.out.println("Task 2");
                });

        CompletableFuture<Void> f3 =
                CompletableFuture.runAsync(() -> {
                    sleep(1000);
                    System.out.println("Task 3");
                });

        CompletableFuture.allOf(
                f1, f2, f3
        ).join();

        System.out.println("All completed");
    }

    private static void sleep(int ms) {

        try {
            Thread.sleep(ms);
        } catch (Exception e) {
        }
    }
}
