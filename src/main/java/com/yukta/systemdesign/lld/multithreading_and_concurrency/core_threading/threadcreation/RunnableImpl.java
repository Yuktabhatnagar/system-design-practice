package com.yukta.systemdesign.lld.multithreading_and_concurrency.core_threading.threadcreation;

class MyThread2 implements Runnable {

    @Override
    public void run() {
        System.out.println("Thread running: " + Thread.currentThread().getName());
    }
}

public class RunnableImpl {
    public static void main(String[] args) {// Thread using Runnable Interface
        // Thread using Runnable Interface
        Thread t1 = new Thread(new MyThread2());
        Thread t2 = new Thread(new MyThread2());

        t1.start();
        t2.start();
    }
}
