package com.yukta.systemdesign.lld.multithreading.core_threading.synchronized_keyword;


public class Counter {
    public static void main(String[] args) {

        Thread t1 = new Thread(() -> Counter1.increment());

        Thread t2 = new Thread(() -> Counter1.increment());

        t1.start();
        t2.start();
    }
}

// Static Synchronization

class Counter1 {

    static int count = 0;

    static void increment() {
        synchronized(Counter.class) {
            try {
                Thread.sleep(2000);
            }
            catch(Exception e) {}

            count++;
            System.out.println(count);
        }
    }
}
