package com.yukta.systemdesign.lld.multithreading.modern_java_concurrency.completablefuture;

import java.util.concurrent.CompletableFuture;

public class RunAsyncDemo {

    public static void main(String[] args) {

        CompletableFuture<Void> future =
                CompletableFuture.runAsync(() -> {

                    System.out.println(
                            "Background task running"
                    );
                });

        future.join();
    }
}
