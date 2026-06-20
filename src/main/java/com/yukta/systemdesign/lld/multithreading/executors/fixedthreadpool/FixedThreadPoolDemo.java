package com.yukta.systemdesign.lld.multithreading.executors.fixedthreadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPoolDemo {

    public static void main(String[] args) {

        ExecutorService executor =
                Executors.newFixedThreadPool(3);

        for (int i = 1; i <= 10; i++) {

            int taskId = i;

            executor.submit(() -> {

                System.out.println(
                        "Task " + taskId
                                + " executed by "
                                + Thread.currentThread().getName()
                );

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                }
            });
        }

        executor.shutdown();
    }
}
