package com.yukta.systemdesign.lld.multithreading.collection_and_concurrency.concurrent_hashmap;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapDemo {

    public static void main(String[] args)
            throws Exception {

        ConcurrentHashMap<Integer, String> map =
                new ConcurrentHashMap<>();

        Thread t1 = new Thread(() -> {

            for(int i=1; i<=5; i++) {

                map.put(i, "User-" + i);
            }
        });

        Thread t2 = new Thread(() -> {

            for(int i=6; i<=10; i++) {

                map.put(i, "User-" + i);
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(map);
    }
}
