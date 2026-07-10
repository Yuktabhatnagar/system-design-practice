package com.yukta.systemdesign.lld.multithreading.modern_java_concurrency.virtualthreads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VirtualThreadExecutorDemo {

    public static void main(String[] args)
            throws Exception {

        try (ExecutorService executor =
                     Executors.newVirtualThreadPerTaskExecutor()) {

            for (int i = 1; i <= 10; i++) {

                int taskId = i;

                executor.submit(() -> {

                    System.out.println(
                            "Task "
                                    + taskId
                                    + " running on "
                                    + Thread.currentThread()
                    );

                    return null;
                });
            }
        }
    }
}
