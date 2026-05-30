package com.yukta.systemdesign.lld.multithreading.core_threading.multithreading_problems;


    class Counter1 {
        int count = 0;

        public synchronized void increment() {
            count++;
        }
    }

    public class SynchronizedSolution {
        public static void main(String[] args)
                throws Exception {
            Counter1 counter = new Counter1();
            Thread t1 = new Thread(() -> {
                for (int i = 0; i < 1000; i++) {
                    counter.increment();
                }
            });
            Thread t2 = new Thread(() -> {
                for (int i = 0; i < 1000; i++) {
                    counter.increment();
                }
            });
            t1.start();
            t2.start();
            t1.join();
            t2.join();
            System.out.println(counter.count);
        }
}
