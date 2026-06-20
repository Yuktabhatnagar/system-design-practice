package com.yukta.systemdesign.lld.multithreading.modern_java_concurrency.future;

import java.util.concurrent.*;

public class FutureDemo2 {

    public static void main(String[] args)
            throws Exception {

        ExecutorService executor =
                Executors.newSingleThreadExecutor();

        Future<Integer> future =
                executor.submit(() -> {

                    int sum = 0;

                    for(int i=1;i<=100;i++) {
                        sum += i;
                    }

                    return sum;
                });

        System.out.println(
                "Result = " + future.get()
        );

        executor.shutdown();
    }
}



