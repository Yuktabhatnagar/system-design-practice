package com.yukta.systemdesign.lld.multithreading_and_concurrency.core_threading.threadmethods;

public class Daemon {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            while (true) {
                System.out.println("Running...");
            }
        });

        t1.setDaemon(true);
        t1.start();

        try {
            Thread.sleep(500);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

/*

   Daemon Threads --> Background running threads
   --> Stop immediately once main thread is completed

   Threads --> User threads, Daemon threads

    Garbage collection --> Daemon thread
*/
