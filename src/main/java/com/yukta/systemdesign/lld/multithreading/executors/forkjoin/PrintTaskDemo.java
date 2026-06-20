package com.yukta.systemdesign.lld.multithreading.executors.forkjoin;

import java.util.concurrent.*;

public class PrintTaskDemo {

    static class PrintTask
            extends RecursiveAction {

        private int start;
        private int end;

        public PrintTask(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected void compute() {

            if(end - start <= 5) {

                for(int i=start;i<=end;i++) {
                    System.out.println(i);
                }

                return;
            }

            int mid = (start + end)/2;

            invokeAll(
                    new PrintTask(start, mid),
                    new PrintTask(mid+1, end)
            );
        }
    }

    public static void main(String[] args) {

        ForkJoinPool pool =
                new ForkJoinPool();

        pool.invoke(
                new PrintTask(1,20)
        );
    }
}
