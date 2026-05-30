package com.yukta.systemdesign.lld.multithreading.core_threading.synchronized_keyword;

public class MonitorLock3 {
    public static void main(String[] args) {

        Test2 test = new Test2();

        Thread t1 = new Thread(() -> test.m1());

        Thread t2 = new Thread(() -> test.m2());

        t1.start();
        t2.start();
    }
}

class Test2 {
    static void m1() {
        synchronized(Test.class) {
            System.out.println("m1 entered");

            try {
                Thread.sleep(2000);
            }
            catch(Exception e) {};

            System.out.println("m1 exit");
        }
    }

    void m2() {
        synchronized(this) {
            System.out.println("m2 entered");

            try {
                Thread.sleep(2000);
            }
            catch(Exception e) {};

            System.out.println("m2 exit");
        }
    }
}
