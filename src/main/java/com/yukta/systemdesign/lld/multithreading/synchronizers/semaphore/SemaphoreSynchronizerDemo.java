package com.yukta.systemdesign.lld.multithreading.synchronizers.semaphore;

import java.util.concurrent.Semaphore;

public class SemaphoreSynchronizerDemo {

    public static void main(String[] args) {
        Semaphore printerSlots = new Semaphore(2);

        for (int i = 1; i <= 5; i++) {
            int jobId = i;
            new Thread(() -> print(jobId, printerSlots)).start();
        }
    }

    private static void print(int jobId, Semaphore printerSlots) {
        try {
            printerSlots.acquire();
            System.out.println("Printing job " + jobId);
        } catch (InterruptedException exception) {
            Thread.currentThread().interrupt();
        } finally {
            printerSlots.release();
        }
    }
}
