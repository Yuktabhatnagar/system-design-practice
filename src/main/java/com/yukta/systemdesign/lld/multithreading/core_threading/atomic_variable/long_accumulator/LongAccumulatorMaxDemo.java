package com.yukta.systemdesign.lld.multithreading.core_threading.atomic_variable.long_accumulator;

import java.util.concurrent.atomic.LongAccumulator;

public class LongAccumulatorMaxDemo {

    public static void main(String[] args) {

        LongAccumulator max =
                new LongAccumulator(
                        Long::max,
                        Long.MIN_VALUE);

        max.accumulate(10);
        max.accumulate(50);
        max.accumulate(30);

        System.out.println(max.get());
    }
}
