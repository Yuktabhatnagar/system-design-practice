package com.yukta.systemdesign.lld.multithreading.core_threading.atomic_variable.long_accumulator;

import java.util.concurrent.atomic.LongAccumulator;

public class HighestValueThreads {

    static LongAccumulator max =
            new LongAccumulator(
                    Long::max,
                    Long.MIN_VALUE);

    public static void main(String[] args)
            throws Exception {

        Runnable task = () -> {

            long value =
                    (long)(Math.random() * 1000);

            max.accumulate(value);
        };

        for(int i=0;i<100;i++) {
            new Thread(task).start();
        }

        Thread.sleep(2000);

        System.out.println(max.get());
    }
}
