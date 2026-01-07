package machine_coding.rate_limiter;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SlidingWindowRateLimiter implements RateLimiter {
    private final int maxRequests;
    private final long windowSizeMillis;
    private final Map<String, Deque<Long>> requestLogs = new ConcurrentHashMap<>();

    public SlidingWindowRateLimiter(int maxRequests, long windowSizeMillis) {
        this.maxRequests = maxRequests;
        this.windowSizeMillis = windowSizeMillis;

    }

    /*
     * - Maintain a queue/deque of all request timestamps
     * - On each request:
     *   1. Remove timestamps older than (currentTime - windowSize)
     *   2. If remaining count < limit: allow and add timestamp
     *   3. Else: reject
     *
     * * Why Deque?
     * - FIFO structure (oldest timestamps removed first)
     * - Efficient removal from front: O(1)
     * - Efficient addition to back: O(1)
     */
    @Override
    public synchronized boolean allowRequest(String userId) {
        long currentTime = System.currentTimeMillis();
        requestLogs.putIfAbsent(userId, new LinkedList<>());
        Deque<Long> timestamps = requestLogs.get(userId);
        while (!timestamps.isEmpty() && currentTime - timestamps.peek() >= windowSizeMillis) {
            timestamps.pollFirst();
        }
        if (timestamps.size() < maxRequests) {
            timestamps.add(currentTime);
            return true;
        }
        return false;
    }
}
