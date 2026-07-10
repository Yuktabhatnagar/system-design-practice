package com.yukta.systemdesign.lld.multithreading.core_threading.synchronized_keyword;


public class MonitorLock2 {
    public static void main(String[] args) {

        Test1 test = new Test1();

        Thread t1 = new Thread(test::m1);

        Thread t2 = new Thread(test::m2);

        t1.start();
        t2.start();
    }
}

class Test1 {
    synchronized void m1() {
        System.out.println("m1 entered");

        try {
            Thread.sleep(2000);
        }
        catch(Exception e) {
            e.printStackTrace();
        }

        System.out.println("m1 exit");
    }

    synchronized void m2() {
        System.out.println("m2 entered");

        try {
            Thread.sleep(2000);
        }
        catch(Exception e) {};

        System.out.println("m2 exit");

    }
}
