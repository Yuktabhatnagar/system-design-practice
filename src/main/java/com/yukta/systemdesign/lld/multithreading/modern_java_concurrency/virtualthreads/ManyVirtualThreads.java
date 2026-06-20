package com.yukta.systemdesign.lld.multithreading.modern_java_concurrency.virtualthreads;

public class ManyVirtualThreads {

    public static void main(String[] args)
            throws Exception {

        for(int i=1; i<=10; i++) {

            int id = i;

            Thread.startVirtualThread(() -> {

                System.out.println(
                        "Task " + id
                                + " -> "
                                + Thread.currentThread()
                );
            });
        }

        Thread.sleep(1000);
    }
}
