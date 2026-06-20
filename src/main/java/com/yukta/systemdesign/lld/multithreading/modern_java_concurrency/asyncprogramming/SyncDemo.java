package com.yukta.systemdesign.lld.multithreading.modern_java_concurrency.asyncprogramming;

public class SyncDemo {

    public static void fetchUser() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }

        System.out.println("User fetched");
    }

    public static void main(String[] args) {

        System.out.println("Start");

        fetchUser();

        System.out.println("End");
    }
}
