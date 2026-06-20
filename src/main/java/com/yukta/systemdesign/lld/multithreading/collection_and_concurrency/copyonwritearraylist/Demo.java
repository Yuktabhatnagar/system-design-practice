package com.yukta.systemdesign.lld.multithreading.collection_and_concurrency.copyonwritearraylist;

import java.util.concurrent.CopyOnWriteArrayList;

public class Demo {

    public static void main(String[] args) {

        CopyOnWriteArrayList<String> list =
                new CopyOnWriteArrayList<>();

        list.add("A");
        list.add("B");
        list.add("C");

        for(String item : list) {

            System.out.println(item);

            if(item.equals("B")) {
                list.add("D");
            }
        }

        System.out.println(list);
    }
}
