package com.yukta.systemdesign.lld.multithreading.modern_java_concurrency.virtualthreads;
public class VirtualThreadDemo {

    public static void main(String[] args)
            throws InterruptedException {

        Thread vt = Thread.startVirtualThread(() -> {

            System.out.println(
                    "Running in: "
                            + Thread.currentThread()
            );
        });

        vt.join();
    }
}
