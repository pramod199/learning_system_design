package lld_algomaster.splitwise.entities;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class Expense {
    private final String id;
    private final String description;
    private final double amount;
    private final User paidBy;

    private List<Split> splits;

    private final LocalDateTime timestamp;

    public Expense(String description, double amount, User paidBy) {
        this.id = UUID.randomUUID().toString();
        this.description = description;
        this.amount = amount;
        this.paidBy = paidBy;
        this.timestamp = LocalDateTime.now();
    }

    public void setSplits(List<Split> splits) {
        this.splits = splits;
    }

    public String getId() { return id; }
    public String getDescription() { return description; }
    public double getAmount() { return amount; }
    public User getPaidBy() { return paidBy; }
    public List<Split> getSplits() { return splits; }

}
