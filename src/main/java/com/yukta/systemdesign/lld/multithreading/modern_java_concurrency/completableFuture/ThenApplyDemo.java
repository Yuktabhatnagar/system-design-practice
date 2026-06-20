package com.yukta.systemdesign.lld.multithreading.modern_java_concurrency.completablefuture;

import java.util.concurrent.CompletableFuture;

public class ThenApplyDemo {

    public static void main(String[] args) {

        CompletableFuture<String> future =
                CompletableFuture.supplyAsync(() -> "Yukta")

                        .thenApply(name -> name.toUpperCase())

                        .thenApply(name -> "Hello " + name);

        System.out.println(future.join());
    }
}
