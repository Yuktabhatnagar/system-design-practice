package com.yukta.systemdesign.lld.multithreading.core_threading.atomic_variable.long_accumulator;

import java.util.concurrent.atomic.LongAccumulator;

public class LongAccumulatorMinDemo {

    public static void main(String[] args) {

        LongAccumulator min =
                new LongAccumulator(
                        Long::min,
                        Long.MAX_VALUE);

        min.accumulate(10);
        min.accumulate(50);
        min.accumulate(30);

        System.out.println(min.get());
    }
}
