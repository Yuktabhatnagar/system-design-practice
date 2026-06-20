package com.yukta.systemdesign.lld.multithreading.core_threading.starvation;

public class StarvationPriorityDemo {

    public static void main(String[] args) {

        Thread high = new Thread(() -> {

            while (true) {
                System.out.println("High Priority");
            }

        });

        Thread low = new Thread(() -> {

            while (true) {
                System.out.println("Low Priority");
            }

        });

        high.setPriority(Thread.MAX_PRIORITY);
        low.setPriority(Thread.MIN_PRIORITY);

        high.start();
        low.start();
    }
}