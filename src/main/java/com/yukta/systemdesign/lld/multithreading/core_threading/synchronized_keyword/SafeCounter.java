package com.yukta.systemdesign.lld.multithreading.core_threading.synchronized_keyword;

class SafeCounter {
    private int count = 0;
//   The method implicitly locks on this (the current object).
    // Entire method is protected by the instance’s monitor lock
    // Only one thread can run increment() (or any other synchronized method of the same object) at a time.
    public synchronized void increment() {
        count++;          // atomic under the lock
    }

    public synchronized int getCount() {
        return count;
    }
}
