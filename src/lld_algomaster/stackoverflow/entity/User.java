package lld_algomaster.stackoverflow.entity;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public class User {
    private final String id;
    private final String name;
    private AtomicInteger reputation;

    public User(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.reputation = new AtomicInteger(0);
    }

    public void updateReputation(int change) {
        this.reputation.addAndGet(change);
    }

    // getters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public AtomicInteger getReputation() {
        return reputation;
    }
}
