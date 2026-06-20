package com.yukta.systemdesign.lld.multithreading.modern_java_concurrency.asyncprogramming;

import java.util.concurrent.CompletableFuture;

public class AsyncReturnDemo {

    public static void main(String[] args) {

        CompletableFuture<String> future =
                CompletableFuture.supplyAsync(() -> {

                    try {
                        Thread.sleep(3000);
                    } catch (Exception e) {
                    }

                    return "Yukta";
                });

        System.out.println("Doing other work...");

        System.out.println(future.join());
    }
}
