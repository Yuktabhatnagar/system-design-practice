package com.yukta.systemdesign.lld.multithreading.core_threading.thread_methods;

import static java.lang.Thread.interrupted;

public class Interrupt {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            while(!interrupted()) {
                System.out.println("Running");
            }
        });

        t1.start();

        Thread.sleep(1000);

        t1.interrupt();
    }
}

/*
    Thread --> interrupt flag (default true)

    t1.interrupt() --> Sends a signal to t1 thread that it should stop doing what its doing.

    We can gracefully handle
    --> You can make a thread run until a condition
    --> Cancelling a long-running task
    --> uses to stop Thread pool

    isInterrupted() --> return interrupt flag value (T/F)
    interrupted() --> return interrupt flag value (T/F) but also set it back to false

    -> sleep(), join(), wait() : TIMED_WAITING, WAITING --> interrupt()
*/
