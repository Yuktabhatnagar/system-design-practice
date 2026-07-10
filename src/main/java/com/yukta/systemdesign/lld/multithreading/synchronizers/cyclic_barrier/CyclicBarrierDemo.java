package com.yukta.systemdesign.lld.multithreading.synchronizers.cyclic_barrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {

    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(3, () -> System.out.println("Batch started"));

        for (int i = 1; i <= 3; i++) {
            int workerId = i;
            new Thread(() -> waitAtBarrier(workerId, barrier)).start();
        }
    }

    private static void waitAtBarrier(int workerId, CyclicBarrier barrier) {
        try {
            System.out.println("Worker " + workerId + " waiting");
            barrier.await();
            System.out.println("Worker " + workerId + " running");
        } catch (InterruptedException exception) {
            Thread.currentThread().interrupt();
        } catch (BrokenBarrierException exception) {
            throw new IllegalStateException("Barrier was broken", exception);
        }
    }
}
