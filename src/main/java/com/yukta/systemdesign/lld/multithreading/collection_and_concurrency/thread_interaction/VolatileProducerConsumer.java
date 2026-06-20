package com.yukta.systemdesign.lld.multithreading.collection_and_concurrency.thread_interaction;

public class VolatileProducerConsumer {
    public static void main(String[] args) {
        Box1 box = new Box1();

        Thread t1 = new Thread(() -> {
            for(int i=1; i<=20; i++) {
                try{
                    Thread.sleep(100);
                }
                catch(Exception e) {}
                box.producer(i);
            }
        });

        Thread t2 = new Thread(() -> {
            for(int i=1; i<=20; i++) {
                try{
                    Thread.sleep(70);
                }
                catch(Exception e) {}
                box.consumer();
            }
        });

        t1.start();
        t2.start();
    }
}

class Box1 {
    volatile Integer item;
    volatile Boolean flag = false;

    synchronized void producer(int value) {

        while(flag == true) {
            // do nothing
        }

        item = value;
        flag = true;
        System.out.println("Producer produces " + item);
    }
// If thread run for consumer first, while(flag == false) will be true,
// and then it will stick in this phase as it's synchronized.
    synchronized void consumer() {

        while(flag == false) {
            // do nothing
        }

        System.out.println("Consumer consumes " + item);
        item = null;
        flag = false;
    }
}
