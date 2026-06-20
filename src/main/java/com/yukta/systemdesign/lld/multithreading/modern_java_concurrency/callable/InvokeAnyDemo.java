package com.yukta.systemdesign.lld.multithreading.modern_java_concurrency.callable;

import java.util.concurrent.*;
import java.util.*;

public class InvokeAnyDemo {

    public static void main(String[] args)
            throws Exception {

        ExecutorService executor =
                Executors.newFixedThreadPool(3);

        List<Callable<String>> tasks =
                List.of(

                        () -> {
                            Thread.sleep(3000);
                            return "Slow";
                        },

                        () -> {
                            Thread.sleep(1000);
                            return "Fast";
                        },

                        () -> {
                            Thread.sleep(2000);
                            return "Medium";
                        }
                );

        String result =
                executor.invokeAny(tasks);

        System.out.println(result);

        executor.shutdown();
    }
}
