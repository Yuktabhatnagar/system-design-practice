package com.yukta.systemdesign.lld.multithreading.modern_java_concurrency.callable;

import java.util.concurrent.*;

public class CallableDemo {

    public static void main(String[] args)
            throws Exception {

        ExecutorService executor =
                Executors.newSingleThreadExecutor();

        Callable<String> task = () -> {

            Thread.sleep(2000);

            return "Hello Yukta";
        };

        Future<String> future =
                executor.submit(task);

        System.out.println("Doing other work...");

        String result = future.get();

        System.out.println(result);

        executor.shutdown();
    }
}
