package com.yukta.systemdesign.lld.multithreading.core_threading.multithreading_problems;

class Counter {
        int count = 0;
        public void increment() {
            count++;
        }
    }
    public class RaceConditionDemo {
        public static void main(String[] args)
                throws Exception {
            Counter counter = new Counter();
            Thread t1 = new Thread(() -> {
                for(int i = 0; i < 1000; i++) {
                    counter.increment();
                }
            });
            Thread t2 = new Thread(() -> {
                for(int i = 0; i < 1000; i++) {
                    counter.increment();
                }
            });
            t1.start();
            t2.start();
            t1.join();
            t2.join();
            System.out.println(counter.count);
        }

}
/*Expected:
2000
Actual may be:
1734
1901
1980*/