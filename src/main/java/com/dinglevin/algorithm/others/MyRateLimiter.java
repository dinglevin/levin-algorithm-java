package com.dinglevin.algorithm.others;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static com.google.common.base.Preconditions.checkArgument;

/**
 * 描述:
 *
 * @author dinglevin
 * @since 2024/4/15 14:16
 */
public class MyRateLimiter {
    private final long capacity;
    private final long ratePace;
    private final long interval;

    private final Lock lock = new ReentrantLock();

    private volatile long leftToken;
    private volatile long lastUpdated;

    private volatile long nextToUpdate;

    public MyRateLimiter(long capacity, long ratePace) {
        this.capacity = capacity;
        this.ratePace = ratePace;
        this.interval = TimeUnit.SECONDS.toMicros(1L) / capacity;
        this.leftToken = capacity;
        this.lastUpdated = System.nanoTime();
        this.nextToUpdate = this.lastUpdated + interval;
    }

    public boolean acquire() {
        return acquire(1L);
    }

    public boolean acquire(long tokens) {
        checkArgument(tokens > 0, "tokens should be positive");

        this.reSync(System.nanoTime());
        if (this.leftToken >= tokens) {
            lock.lock();
            try {
                if (leftToken >= tokens) {
                    this.leftToken = this.leftToken - tokens;
                    return true;
                }
            } finally {
                lock.unlock();
            }
        }
        return false;
    }

    private void reSync(long now) {
        if (now > this.nextToUpdate) {
            lock.lock();
            try {
                long delta = Math.max(0, now - this.lastUpdated);
                long tokensToAdd = TimeUnit.NANOSECONDS.toMicros(delta) / interval * ratePace;
                this.leftToken = Math.min(this.capacity, this.leftToken + tokensToAdd);
            } finally {
                lock.unlock();
            }
            this.lastUpdated = now;
            this.nextToUpdate = now + interval;
        }
    }
}
