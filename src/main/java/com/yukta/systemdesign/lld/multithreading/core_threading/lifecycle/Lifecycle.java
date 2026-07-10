package com.yukta.systemdesign.lld.multithreading.core_threading.lifecycle;

class MyThread extends Thread {

    @Override
    public void run() {

        try {

            System.out.println("RUNNING");

            Thread.sleep(2000);

            System.out.println("Completed");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

public class Lifecycle {

    public static void main(String[] args)
            throws Exception {

        MyThread t = new MyThread();

        System.out.println(t.getState());

        t.start();

        System.out.println(t.getState());

        Thread.sleep(500);

        System.out.println(t.getState());

        t.join();

        System.out.println(t.getState());
    }
}
