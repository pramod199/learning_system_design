package machine_coding.rate_limiter;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class LeakyBucketRateLimiter implements RateLimiter {
    private final int capacity; // The capacity of the bucket (max number of queued requests)
    private final long leakRateSecs; // The rate at which requests leak out (requests per second)
    private final Queue<Integer> bucket = new LinkedList<>();

    private final ScheduledExecutorService scheduledExecutorService;

    public LeakyBucketRateLimiter(int capacity, long leakRateSecs) {
        this.capacity = capacity;
        this.leakRateSecs = leakRateSecs;

        // Background task to leak (process) requests at a constant rate
        this.scheduledExecutorService = Executors.newScheduledThreadPool(1);
        scheduledExecutorService.scheduleAtFixedRate(this::leakRequests, 0, leakRateSecs, TimeUnit.SECONDS);
    }

    // Try to add a request to the bucket
    @Override
    public synchronized boolean allowRequest(String userId) {
        if (bucket.size() < capacity) {
            bucket.offer(1);
            return true;
        }
        return false;
    }

    private synchronized void leakRequests() {
        if (!bucket.isEmpty()) {
            bucket.poll();//Request processed
            System.out.println("Request processed. Current bucket size: " + bucket.size());
        }
    }
}
