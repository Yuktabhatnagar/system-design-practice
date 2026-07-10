package com.yukta.systemdesign.lld.multithreading.modern_java_concurrency.callable;

import java.util.concurrent.*;

public class SumCallable {

    public static void main(String[] args)
            throws Exception {

        ExecutorService executor =
                Executors.newSingleThreadExecutor();

        Callable<Integer> task = () -> {

            int sum = 0;

            for(int i=1;i<=100;i++) {
                sum += i;
            }

            return sum;
        };

        Future<Integer> future =
                executor.submit(task);

        System.out.println(
                "Sum = "
                        + future.get()
        );

        executor.shutdown();
    }
}
