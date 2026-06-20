package com.yukta.systemdesign.lld.multithreading.synchronizers.phaser;

import java.util.concurrent.Phaser;

public class PhaserDemo {

    public static void main(String[] args) {
        Phaser phaser = new Phaser(1);

        for (int i = 1; i <= 3; i++) {
            phaser.register();
            int workerId = i;
            new Thread(() -> runWorker(workerId, phaser)).start();
        }

        phaser.arriveAndDeregister();
    }

    private static void runWorker(int workerId, Phaser phaser) {
        System.out.println("Worker " + workerId + " phase 1");
        phaser.arriveAndAwaitAdvance();

        System.out.println("Worker " + workerId + " phase 2");
        phaser.arriveAndDeregister();
    }
}
