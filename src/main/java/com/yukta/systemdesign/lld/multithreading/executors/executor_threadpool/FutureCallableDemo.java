package com.yukta.systemdesign.lld.multithreading.executors.executor_threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureCallableDemo {
    public static void main(String[] args) {
        // Future and Callable

        ExecutorService executor = Executors.newFixedThreadPool(2);

        Future<Integer> f1 = executor.submit(() -> {
            try {
                Thread.sleep(3000);
            }
            catch(Exception e) {}

            return 10;
        });

        try {
            System.out.println(f1.get());
        }
        catch(Exception e) {}
        // if not apply shutdown, Thread pool will not gonna terminate
        executor.shutdown();
    }
}