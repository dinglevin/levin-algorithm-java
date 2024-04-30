package com.dinglevin.algorithm.others;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.Assert.assertEquals;

/**
 * 描述:
 *
 * @author dinglevin
 * @since 2024/4/29 20:38
 */
public class MyRateLimiterTest {
    @Test
    public void testSingleThread() {
        TestResult result = new TestResult();
        MyRateLimiter rateLimiter = new MyRateLimiter(10, 1);
        for (int i = 0; i < 10000; i++) {
            boolean acquired = rateLimiter.acquire();
            if (acquired) {
                result.accept();
            } else {
                result.deny();
            }
        }

        System.out.println("Accepted: " + result.accepted.get());
        System.out.println("Denied: " + result.denied.get());

        assertEquals(10, result.accepted.get());
        assertEquals(9990, result.denied.get());
    }

    @Test
    public void testMultiThread() throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(10);

        TestResult result = new TestResult();
        MyRateLimiter rateLimiter = new MyRateLimiter(10, 1);
        for (int i = 0; i < 10000; i++) {
            executor.submit(() -> {
                boolean acquired = rateLimiter.acquire();
                if (acquired) {
                    result.accept();
                } else {
                    result.deny();
                }
            });
        }

        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.SECONDS);

        System.out.println("Accepted: " + result.accepted.get());
        System.out.println("Denied: " + result.denied.get());

        assertEquals(10, result.accepted.get());
        assertEquals(9990, result.denied.get());
    }

    public static class TestResult {
        AtomicInteger accepted = new AtomicInteger(0);
        AtomicInteger denied = new AtomicInteger(0);

        public void accept() {
            accepted.incrementAndGet();
        }

        public void deny() {
            denied.incrementAndGet();
        }
    }
}
