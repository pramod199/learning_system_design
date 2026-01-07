package machine_coding.rate_limiter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TokenBucketRateLimiter implements RateLimiter {
    private final int capacity;
    private final double refillRate; // per second
    private final Map<String, Integer> tokens = new ConcurrentHashMap<>();
    private final Map<String, Long> lastRefillTimestamp = new ConcurrentHashMap<>();

    public TokenBucketRateLimiter(int capacity, double refillRate) {
        this.capacity = capacity;
        this.refillRate = refillRate;
    }
/*
 * Algorithm:
 * - Bucket holds tokens (capacity = max tokens)
 * - Tokens are added at constant rate (refill rate)
 * - Each request consumes 1 token
 * - If tokens available: allow request and decrement
 * - If no tokens: reject request
 * - Bucket never exceeds capacity
 */
    @Override
    public synchronized boolean allowRequest(String userId) {
        long currentTime = System.currentTimeMillis();

        lastRefillTimestamp.putIfAbsent(userId, currentTime);
        tokens.putIfAbsent(userId, capacity);

        long lastRefill = lastRefillTimestamp.get(userId);
        long elapsedTime = (currentTime - lastRefill) / 1000;
        if (elapsedTime > 0) {
            int newTokens = Math.min(capacity, tokens.get(userId) + (int)(elapsedTime*refillRate));
            tokens.put(userId, newTokens);
            lastRefillTimestamp.put(userId, currentTime);
        }
        if (tokens.get(userId) > 0) {
            tokens.put(userId, tokens.get(userId)-1);
            return true;
        }
        return false;
    }
}
