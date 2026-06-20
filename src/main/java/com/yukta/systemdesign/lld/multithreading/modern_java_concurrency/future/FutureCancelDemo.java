package com.yukta.systemdesign.lld.multithreading.modern_java_concurrency.future;

import java.util.concurrent.*;

public class FutureCancelDemo {

    public static void main(String[] args)
            throws Exception {

        ExecutorService executor =
                Executors.newSingleThreadExecutor();

        Future<String> future =
                executor.submit(() -> {

                    Thread.sleep(5000);

                    return "Completed";
                });

        Thread.sleep(1000);

        future.cancel(true);

        System.out.println(
                "Cancelled: "
                        + future.isCancelled()
        );

        executor.shutdown();
    }
}


/*
 If task takes longer:  TimeoutException
try {

    String result =
            future.get(
                    2,
                    TimeUnit.SECONDS
            );

} catch (TimeoutException e) {

    System.out.println("Timed out");
}


        );*/
