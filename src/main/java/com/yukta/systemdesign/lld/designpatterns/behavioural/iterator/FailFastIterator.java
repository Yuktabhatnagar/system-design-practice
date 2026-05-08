package com.yukta.systemdesign.lld.designpatterns.behavioural.iterator;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FailFastIterator {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();

        list.add("A");
        list.add("B");

        Iterator<String> it = list.iterator();

        while(it.hasNext()) {
            String val = it.next();

            if(val.equals("A")) {
                it.remove(); // ✅ safe
            }
        }
        System.out.println(list);
    }
}