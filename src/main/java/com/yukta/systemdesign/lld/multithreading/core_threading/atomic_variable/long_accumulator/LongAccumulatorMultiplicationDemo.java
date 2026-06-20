package com.yukta.systemdesign.lld.multithreading.core_threading.atomic_variable.long_accumulator;

import java.util.concurrent.atomic.LongAccumulator;

public class LongAccumulatorMultiplicationDemo {

    public static void main(String[] args) {

        LongAccumulator product =
                new LongAccumulator(
                        (x,y) -> x * y,
                        1);

        product.accumulate(2);
        product.accumulate(3);
        product.accumulate(4);

        System.out.println(product.get());
    }
}
