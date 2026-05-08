package com.yukta.systemdesign.lld.designpatterns.behavioural.iterator;


import java.util.*;

public class FailFastIteratorException {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();

        list.add("A");
        list.add("B");

        Iterator<String> it = list.iterator();

        while (it.hasNext()) {

            String value = it.next();

            if (value.equals("A")) {
                list.add("C");
                // ❌ modifying collection directly
            }
        }
    }
}