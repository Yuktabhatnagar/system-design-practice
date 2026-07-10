package com.yukta.systemdesign.lld.multithreading.modern_java_concurrency.threadlocal;

public class ThreadLocalIsolation {

    private static final ThreadLocal<Integer> counter =
            new ThreadLocal<>();

    public static void main(String[] args) {

        Runnable task = () -> {

            counter.set(0);

            for(int i=1;i<=5;i++) {

                counter.set(
                        counter.get() + 1
                );
            }

            System.out.println(
                    Thread.currentThread().getName()
                            + " : "
                            + counter.get()
            );
        };

        new Thread(task, "T1").start();
        new Thread(task, "T2").start();
    }
}
