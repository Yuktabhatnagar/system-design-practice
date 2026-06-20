package com.yukta.systemdesign.lld.multithreading.synchronizers.countdown_latch;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(3);

        for (int i = 1; i <= 3; i++) {
            int workerId = i;
            new Thread(() -> {
                System.out.println("Worker " + workerId + " ready");
                latch.countDown();
            }).start();
        }

        latch.await();
        System.out.println("All workers are ready");
    }
}
