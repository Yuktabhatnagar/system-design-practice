package com.yukta.systemdesign.lld.multithreading.executors.cachedthreadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPoolDemo {

    public static void main(String[] args) {

        ExecutorService executor =
                Executors.newCachedThreadPool();

        for (int i = 1; i <= 20; i++) {

            int taskId = i;

            executor.submit(() -> {

                System.out.println(
                        "Task "
                                + taskId
                                + " -> "
                                + Thread.currentThread().getName()
                );

                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                }
            });
        }

        executor.shutdown();
    }
}
