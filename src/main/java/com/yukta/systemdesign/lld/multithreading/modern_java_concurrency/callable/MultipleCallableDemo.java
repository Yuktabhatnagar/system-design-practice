package com.yukta.systemdesign.lld.multithreading.modern_java_concurrency.callable;

import java.util.concurrent.*;
import java.util.*;

public class MultipleCallableDemo {

    public static void main(String[] args)
            throws Exception {

        ExecutorService executor =
                Executors.newFixedThreadPool(3);

        List<Callable<Integer>> tasks =
                List.of(

                        () -> 100,

                        () -> 200,

                        () -> 300
                );

        List<Future<Integer>> futures =
                executor.invokeAll(tasks);

        for(Future<Integer> future : futures) {

            System.out.println(
                    future.get()
            );
        }

        executor.shutdown();
    }
}
