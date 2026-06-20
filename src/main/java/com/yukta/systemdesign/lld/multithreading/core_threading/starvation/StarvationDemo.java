package com.yukta.systemdesign.lld.multithreading.core_threading.starvation;

import java.util.concurrent.locks.ReentrantLock;

public class StarvationDemo {

    private static final ReentrantLock lock =
            new ReentrantLock(); // unfair lock (default)

    public static void main(String[] args) {

        Runnable greedyTask = () -> {

            while (true) {

                lock.lock();

                try {

                    System.out.println(
                            Thread.currentThread().getName()
                                    + " acquired lock");

                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException ignored) {}

                } finally {
                    lock.unlock();
                }
            }
        };

        Thread t1 = new Thread(greedyTask, "Greedy-1");
        Thread t2 = new Thread(greedyTask, "Greedy-2");

        Thread starvingThread = new Thread(() -> {

            while (true) {

                lock.lock();

                try {

                    System.out.println(
                            "***** Starving Thread finally got lock *****"
                    );

                } finally {
                    lock.unlock();
                }

                break;
            }

        }, "Starving");

        t1.start();
        t2.start();

        try {
            Thread.sleep(100);
        } catch (InterruptedException ignored) {}

        starvingThread.start();
    }
}
