package com.yukta.systemdesign.lld.multithreading.core_threading.atomic_variable.atomic_stamped_reference;

import java.util.concurrent.atomic.AtomicStampedReference;

public class ABAExample {

    static AtomicStampedReference<Integer> ref =
            new AtomicStampedReference<>(100, 1);

    public static void main(String[] args)
            throws Exception {

        Thread t1 = new Thread(() -> {

            int stamp = ref.getStamp();

            try {
                Thread.sleep(3000);
            } catch (Exception e) {}

            boolean success =
                    ref.compareAndSet(
                            100,
                            200,
                            stamp,
                            stamp + 1);

            System.out.println("T1 Success : " + success);
        });

        Thread t2 = new Thread(() -> {

            int stamp = ref.getStamp();

            ref.compareAndSet(
                    100,
                    101,
                    stamp,
                    stamp + 1);

            stamp = ref.getStamp();

            ref.compareAndSet(
                    101,
                    100,
                    stamp,
                    stamp + 1);
        });

        t1.start();
        Thread.sleep(100);
        t2.start();
    }
}
