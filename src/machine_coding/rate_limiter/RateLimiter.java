package machine_coding.rate_limiter;

public interface RateLimiter {
    boolean allowRequest(String userId);
}
