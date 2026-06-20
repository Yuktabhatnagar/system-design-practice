package com.yukta.systemdesign.lld.multithreading.modern_java_concurrency.virtualthreads;

import java.util.concurrent.*;

public class VirtualThreadCallable {

    public static void main(String[] args)
            throws Exception {

        try (ExecutorService executor =
                     Executors.newVirtualThreadPerTaskExecutor()) {

            Future<String> future =
                    executor.submit(() -> {

                        Thread.sleep(2000);

                        return "Hello Yukta";
                    });

            System.out.println(
                    future.get()
            );
        }
    }
}
