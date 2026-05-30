package com.yukta.systemdesign.lld.multithreading.core_threading.volatile_keyword;


class SharedDataVolatile {
    volatile boolean flag = false;

    public void writer() {
        flag = true;
    }

    public void reader() {
        if (flag) {
            // guaranteed to see true if another thread wrote it
        }
    }
}
