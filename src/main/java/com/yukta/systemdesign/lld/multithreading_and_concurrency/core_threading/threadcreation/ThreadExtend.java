package com.yukta.systemdesign.lld.multithreading_and_concurrency.core_threading.threadcreation;

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("Thread running: "
                + Thread.currentThread().getName());
    }
}
public class ThreadExtend {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.start();
        MyThread t2 = new MyThread();
        t2.start();
    }
}
