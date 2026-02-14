package machine_coding.uber.expiry_counter;

import java.util.*;

// sliding window
// https://leetcode.com/discuss/post/7043175/uber-l5a-sse-interview-experience-by-nik-qpdr/
public class ExpiryCounter {
    private final long expiryMillis;
    private final Map<String, Deque<Long>> logs = new HashMap<>();

    public ExpiryCounter(long expirySeconds) {
        this.expiryMillis = expirySeconds * 1000;
    }

    public void putElement(String key) {
        long now = System.currentTimeMillis();
        logs.computeIfAbsent(key, k -> new ArrayDeque<>())
                .addLast(now);
    }

    public int getElementCount(String key) {
        long now = System.currentTimeMillis();
        Deque<Long> dq = logs.get(key);
        if (dq == null) return 0;

        evictExpired(dq, now); // cleanup
        if (dq.isEmpty()) {
            logs.remove(key);
            return 0;
        }
        return dq.size();
    }

    public int getTotalElements() {
        long now = System.currentTimeMillis();
        int total = 0;

        Iterator<Map.Entry<String, Deque<Long>>> it = logs.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Deque<Long>> e = it.next();
            Deque<Long> dq = e.getValue();
            evictExpired(dq, now); // cleanup
            if (dq.isEmpty()) {
                it.remove();
            } else {
                total += dq.size();
            }
        }
        return total;
    }

    private void evictExpired(Deque<Long> dq, long now) {
        long threshold = now - expiryMillis;
        while (!dq.isEmpty() && dq.peekFirst() < threshold) {
            dq.pollFirst();
        }
    }


}
