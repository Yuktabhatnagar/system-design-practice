package com.yukta.systemdesign.lld.multithreading.executors.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinPoolDemo {

    static class SumTask extends RecursiveTask<Long> {

        private final int[] arr;
        private final int start;
        private final int end;

        private static final int THRESHOLD = 100;

        public SumTask(int[] arr, int start, int end) {
            this.arr = arr;
            this.start = start;
            this.end = end;
        }

        @Override
        protected Long compute() {

            if (end - start <= THRESHOLD) {

                long sum = 0;

                for (int i = start; i < end; i++) {
                    sum += arr[i];
                }

                return sum;
            }

            int mid = (start + end) / 2;

            SumTask left =
                    new SumTask(arr, start, mid);

            SumTask right =
                    new SumTask(arr, mid, end);

            left.fork(); // execute asynchronously

            Long rightResult =
                    right.compute();

            Long leftResult =
                    left.join();

            return leftResult + rightResult;
        }
    }

    public static void main(String[] args) {

        int[] arr = new int[1000];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }

        ForkJoinPool pool =
                new ForkJoinPool();

        Long result =
                pool.invoke(
                        new SumTask(
                                arr,
                                0,
                                arr.length
                        )
                );

        System.out.println(result);
    }
}
