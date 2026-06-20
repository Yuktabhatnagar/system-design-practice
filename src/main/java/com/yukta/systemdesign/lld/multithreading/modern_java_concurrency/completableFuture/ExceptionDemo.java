package com.yukta.systemdesign.lld.multithreading.modern_java_concurrency.completablefuture;

import java.util.concurrent.CompletableFuture;

public class ExceptionDemo {

    public static void main(String[] args) {

        CompletableFuture<Integer> future =
                CompletableFuture.supplyAsync(() -> {

                            int x = 10 / 0;

                            return x;
                        })

                        .exceptionally(ex -> {

                            System.out.println("Error: "
                                    + ex.getMessage());

                            return -1;
                        });

        System.out.println(future.join());
    }
}
