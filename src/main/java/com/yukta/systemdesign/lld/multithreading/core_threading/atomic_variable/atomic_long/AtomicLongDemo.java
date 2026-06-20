package com.yukta.systemdesign.lld.multithreading.core_threading.atomic_variable.atomic_long;

import java.util.concurrent.atomic.AtomicLong;

public class AtomicLongDemo {

    public static void main(String[] args)
            throws InterruptedException {

        AtomicLong counter =
                new AtomicLong(0);

        Thread t1 = new Thread(() -> {

            for(int i=0; i<10000; i++) {

                counter.incrementAndGet();
            }
        });

        Thread t2 = new Thread(() -> {

            for(int i=0; i<10000; i++) {

                counter.incrementAndGet();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(
                counter.get()
        );
    }
}
