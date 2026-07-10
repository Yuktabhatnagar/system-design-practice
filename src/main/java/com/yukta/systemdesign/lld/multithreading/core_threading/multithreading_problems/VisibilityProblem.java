package com.yukta.systemdesign.lld.multithreading.core_threading.multithreading_problems;

public class VisibilityProblem {

    static  boolean flag = false; // true
    // used volatile to read from RAM Memory directly inspite of local cache of thread.

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(1000);
            }
            catch(Exception e) {}
            flag = true; // cache --> flag = true
        });

        Thread t2 = new Thread(() -> { // cache --> flag = false
            while(!flag) {
//                 System.out.println("Thread 2 Running..."); // synchronized
//                 do nothing
            }
            System.out.println("Thread 2 finished");
        });

        t1.start();
        t2.start();
    }
}
