package com.yukta.systemdesign.lld.multithreading.modern_java_concurrency.completablefuture;

import java.util.concurrent.CompletableFuture;

public class CombineDemo {

    public static void main(String[] args) {

        CompletableFuture<String> userFuture =
                CompletableFuture.supplyAsync(() -> "Yukta");

        CompletableFuture<String> accountFuture =
                CompletableFuture.supplyAsync(() -> "Premium");

        CompletableFuture<String> result =
                userFuture.thenCombine(
                        accountFuture,
                        (user, account) ->
                                user + " - " + account
                );

        System.out.println(result.join());
    }
}
