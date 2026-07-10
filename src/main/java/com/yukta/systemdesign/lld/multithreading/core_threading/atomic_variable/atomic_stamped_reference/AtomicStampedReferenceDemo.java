package com.yukta.systemdesign.lld.multithreading.core_threading.atomic_variable.atomic_stamped_reference;

import java.util.concurrent.atomic.AtomicStampedReference;

public class AtomicStampedReferenceDemo {

    public static void main(String[] args) {

        AtomicStampedReference<String> ref =
                new AtomicStampedReference<>("A", 1);

        int stamp = ref.getStamp();

        boolean result =
                ref.compareAndSet(
                        "A",
                        "B",
                        stamp,
                        stamp + 1);

        System.out.println(result);
        System.out.println(ref.getReference());
        System.out.println(ref.getStamp());
    }
}
