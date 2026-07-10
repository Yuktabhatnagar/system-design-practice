package com.yukta.systemdesign.lld.multithreading.collection_and_concurrency.blockingqueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ArrayBlockingQueue;

public class BlockingQueueDemo {

    public static void main(String[] args) {

        BlockingQueue<Integer> queue =
                new ArrayBlockingQueue<>(3);

        Thread producer = new Thread(() -> {

            try {

                for(int i=1; i<=5; i++) {

                    queue.put(i);

                    System.out.println(
                            "Produced: " + i
                    );
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread consumer = new Thread(() -> {

            try {

                while(true) {

                    Integer value =
                            queue.take();

                    System.out.println(
                            "Consumed: " + value
                    );

                    Thread.sleep(1000);
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        producer.start();
        consumer.start();
    }
}

