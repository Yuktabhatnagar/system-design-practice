package com.yukta.systemdesign.lld.designpatterns.behavioural.iterator;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.*;

public class FailSafeIterator {
    public static void main(String[] args) {

        CopyOnWriteArrayList<String> list =
                new CopyOnWriteArrayList<>();

        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");

        Iterator<String> it = list.iterator();

        while(it.hasNext()) {

            String val = it.next();

            System.out.println(val);

            list.add("C"); // ✅ allowed
        }

        System.out.println(list);
    }
}
