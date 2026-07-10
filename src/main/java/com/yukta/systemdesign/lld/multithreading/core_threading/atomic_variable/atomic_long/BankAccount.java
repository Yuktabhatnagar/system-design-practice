package com.yukta.systemdesign.lld.multithreading.core_threading.atomic_variable.atomic_long;

import java.util.concurrent.atomic.AtomicLong;

public class BankAccount {

    private AtomicLong balance =
            new AtomicLong(1000);

    public void deposit(long amount) {

        balance.addAndGet(amount);
    }

    public long getBalance() {

        return balance.get();
    }

    public static void main(String[] args)
            throws Exception {

        BankAccount account =
                new BankAccount();

        Thread t1 = new Thread(() -> {

            for(int i=0;i<1000;i++) {

                account.deposit(10);
            }
        });

        Thread t2 = new Thread(() -> {

            for(int i=0;i<1000;i++) {

                account.deposit(10);
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(
                account.getBalance()
        );
    }
}
