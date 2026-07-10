package com.yukta.systemdesign.lld.multithreading.modern_java_concurrency.asyncprogramming;

import java.util.concurrent.CompletableFuture;

public class AsyncDemo {

    public static void main(String[] args) {

        System.out.println("Start");

        CompletableFuture.runAsync(() -> {

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
            }

            System.out.println("User fetched");
        });

        System.out.println("End");

        try {
            Thread.sleep(4000);
        } catch (Exception e) {
        }
    }
}
