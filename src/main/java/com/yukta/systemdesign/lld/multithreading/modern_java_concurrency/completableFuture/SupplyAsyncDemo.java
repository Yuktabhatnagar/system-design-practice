package com.yukta.systemdesign.lld.multithreading.modern_java_concurrency.completablefuture;

import java.util.concurrent.CompletableFuture;

public class SupplyAsyncDemo {

    public static void main(String[] args) {

        CompletableFuture<String> future =
                CompletableFuture.supplyAsync(() -> {

                    System.out.println("Running in: "
                            + Thread.currentThread().getName());

                    return "Hello Yukta";
                });

        System.out.println(future.join());
    }
}
