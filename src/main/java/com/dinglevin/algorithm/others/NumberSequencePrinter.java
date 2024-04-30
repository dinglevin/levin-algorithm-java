package com.dinglevin.algorithm.others;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 问题描述：3个线程，分别打印1、2、3，并且循环顺序打印10次
 *
 * @author dinglevin
 * @since 2024/4/29 20:50
 */
public class NumberSequencePrinter {
    public static void main(String[] args) throws Exception {
        AtomicInteger totalPrinted = new AtomicInteger(0);
        Semaphore sem1 = new Semaphore(1);
        Semaphore sem2 = new Semaphore(0);
        Semaphore sem3 = new Semaphore(0);

        Thread t1 = new Thread(new Pinter(1, totalPrinted, sem1, sem2));
        Thread t2 = new Thread(new Pinter(2, totalPrinted, sem2, sem3));
        Thread t3 = new Thread(new Pinter(3, totalPrinted, sem3, sem1));

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();
    }

    public static class Pinter implements Runnable {
        private final int printNum;
        private final AtomicInteger totalPrinted;
        private final Semaphore curSem;
        private final Semaphore nextSem;

        public Pinter(int printNum, AtomicInteger totalPrinted, Semaphore curSem, Semaphore nextSem) {
            this.printNum = printNum;
            this.totalPrinted = totalPrinted;
            this.curSem = curSem;
            this.nextSem = nextSem;
        }

        @Override
        public void run() {
            int total = 0;
            while (total < 30) {
                try {
                    curSem.acquire();
                    System.out.println(printNum);
                    total = totalPrinted.incrementAndGet();
                    nextSem.release();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
