package com.yukta.systemdesign.lld.multithreading.core_threading.deadlock;

public class Demo {

    private static final Object lock1 =
            new Object();

    private static final Object lock2 =
            new Object();

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {

            synchronized (lock1) {

                System.out.println(
                        "Thread 1 acquired lock1"
                );

                sleep();

                synchronized (lock2) {

                    System.out.println(
                            "Thread 1 acquired lock2"
                    );
                }
            }
        });

        Thread t2 = new Thread(() -> {

            synchronized (lock2) {

                System.out.println(
                        "Thread 2 acquired lock2"
                );

                sleep();

                synchronized (lock1) {

                    System.out.println(
                            "Thread 2 acquired lock1"
                    );
                }
            }
        });

        t1.start();
        t2.start();
    }

    private static void sleep() {

        try {
            Thread.sleep(1000);
        } catch (Exception e) {
        }
    }
}
