package com.yukta.systemdesign.lld.multithreading.modern_java_concurrency.callable;

import java.util.concurrent.*;

public class ExceptionCallable {

    public static void main(String[] args)
            throws Exception {

        ExecutorService executor =
                Executors.newSingleThreadExecutor();

        Callable<Integer> task = () -> {

            if(true) {
                throw new Exception(
                        "Something went wrong"
                );
            }

            return 10;
        };

        Future<Integer> future =
                executor.submit(task);

        try {

            System.out.println(
                    future.get()
            );

        } catch (ExecutionException e) {

            System.out.println(
                    e.getCause().getMessage()
            );
        }

        executor.shutdown();
    }
}
