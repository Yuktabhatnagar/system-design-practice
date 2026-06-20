package com.yukta.systemdesign.lld.multithreading.executors.scheduledthreadpool;

import java.util.concurrent.*;

public class ScheduledDemo {

    public static void main(String[] args) {

        ScheduledExecutorService scheduler =
                Executors.newScheduledThreadPool(2);

        scheduler.schedule(() -> {

            System.out.println(
                    "Executed after 5 seconds"
            );

        }, 5, TimeUnit.SECONDS);

        scheduler.shutdown();
    }
}
