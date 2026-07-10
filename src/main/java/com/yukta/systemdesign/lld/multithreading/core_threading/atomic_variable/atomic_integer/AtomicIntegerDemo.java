package com.yukta.systemdesign.lld.multithreading.core_threading.atomic_variable.atomic_integer;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerDemo {

    public static void main(String[] args)
            throws InterruptedException {

        Counter counter = new Counter();

        Thread t1 = new Thread(() -> {
            for (int i = 1; i <= 10000; i++) {
                counter.increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 1; i <= 10000; i++) {
                counter.increment();
            }
        });

        t1.start();
        t2.start();

        // Better than sleep()
        t1.join();
        t2.join();

        System.out.println(counter.getCount());
    }
}

class Counter {

    private AtomicInteger count = new AtomicInteger(0);

    void increment() {
        count.incrementAndGet();
    }

    int getCount() {
        return count.get();
    }
}