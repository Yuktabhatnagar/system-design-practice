package com.yukta.systemdesign.lld.designpatterns.behavioural.iterator;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapDemo {

    public static void main(String[] args) {

        ConcurrentHashMap<Integer, String> map =
                new ConcurrentHashMap<>();

        map.put(1, "A");
        map.put(2, "B");

        for(Integer key : map.keySet()) {
            System.out.println(key);
            map.put(3, "C"); // ✅ allowed
        }
    }
}
