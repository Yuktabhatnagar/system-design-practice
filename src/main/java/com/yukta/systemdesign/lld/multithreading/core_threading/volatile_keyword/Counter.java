package com.yukta.systemdesign.lld.multithreading.core_threading.volatile_keyword;
// count++ involves three steps (read, modify, write),
// and volatile cannot stop two threads from performing these steps simultaneously, leading to race conditions.
class Counter {
    volatile int count = 0;

    public void increment() {
        count++; // Still unsafe!
    }
}
