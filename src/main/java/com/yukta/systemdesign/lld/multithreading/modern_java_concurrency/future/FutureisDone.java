package com.yukta.systemdesign.lld.multithreading.modern_java_concurrency.future;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureisDone {

    ExecutorService executor =
            Executors.newSingleThreadExecutor();

    Future<Integer> future =
            executor.submit(() -> {

                int sum = 0;

                for (int i = 1; i <= 100; i++) {
                    sum += i;
                }

                return sum;
            });
}
    /*while(!future.isDone()){

        System.out.println(
                "Task still running..."
        );

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

        System.out.println(future.get());
}*/
