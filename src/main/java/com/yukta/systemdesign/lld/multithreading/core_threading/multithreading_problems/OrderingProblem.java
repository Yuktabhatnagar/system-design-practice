package com.yukta.systemdesign.lld.multithreading.core_threading.multithreading_problems;

public class OrderingProblem {

    static int x = 0;
    static boolean flag = false;
//    instruction reordering
//    CPU cache visibility
//    JMM optimizations
/*
    Reader thread might see: flag = true
    BUT still see: x = 0
*/

    public static void main(String[] args)
            throws Exception {

        Thread writer = new Thread(() -> {

            x = 10;

            flag = true;
        });

        Thread reader = new Thread(() -> {

            if (flag) {
                System.out.println(x);
            }
        });

        writer.start();
        reader.start();

        writer.join();
        reader.join();
    }
}