package com.yukta.systemdesign.lld.multithreading_and_concurrency.core_threading.threadcreation;

public class AdvanceRunnable {
        public static void main(String[] args) {
//            Runnable Interface-> FunctionalInterface so, We can use LambdaExpression
            Thread t1 = new Thread(() -> System.out.println("Thread running: " + Thread.currentThread().getName()));
            t1.start();
    }
}
