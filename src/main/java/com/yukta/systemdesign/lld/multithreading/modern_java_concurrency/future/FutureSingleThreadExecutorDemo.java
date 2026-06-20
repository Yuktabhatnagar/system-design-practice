package com.yukta.systemdesign.lld.multithreading.modern_java_concurrency.future;

import java.util.concurrent.*;

public class FutureSingleThreadExecutorDemo {

    public static void main(String[] args)
            throws Exception {

        ExecutorService executor =
                Executors.newFixedThreadPool(2);

        Future<String> future =
                executor.submit(() -> {

                    Thread.sleep(3000);

                    return "Hello Yukta";
                });

        System.out.println("Doing other work...");

        String result = future.get();

        System.out.println(result);

        executor.shutdown();
    }
}
