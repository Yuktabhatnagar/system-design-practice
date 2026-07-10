package com.yukta.systemdesign.lld.multithreading.modern_java_concurrency.threadlocal;

public class ThreadLocalDemo {

    private static final ThreadLocal<String> user =
            new ThreadLocal<>();

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {

            user.set("Yukta");

            System.out.println(
                    Thread.currentThread().getName()
                            + " -> "
                            + user.get()
            );
        });

        Thread t2 = new Thread(() -> {

            user.set("Rohan");

            System.out.println(
                    Thread.currentThread().getName()
                            + " -> "
                            + user.get()
            );
        });

        t1.start();
        t2.start();
    }
}
