package machine_coding.inmemory_key_value_store;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class KeyValueStore {
    private Map<String, VersionedValue> data = new HashMap<>();
    private ThreadLocal<Transaction> currentTransaction = new ThreadLocal<>();
    private AtomicLong globalVersion = new AtomicLong(0);

    public String get(String key) {
        Transaction transaction = currentTransaction.get();
        if (transaction != null) {
            if (transaction.deleteSet.contains(key)) return null;
            if (transaction.writeSet.containsKey(key)) return transaction.writeSet.get(key);
        }

        VersionedValue vv = data.get(key);
        if (vv == null) return null;

        if (transaction != null) {
            transaction.readSet.put(key, vv);
        }
        return vv.value;
    }

    public void set(String key, String value) {
        Transaction transaction = currentTransaction.get();
        if (transaction != null) {
            transaction.writeSet.put(key, value);
            transaction.deleteSet.remove(key);
        } else {
            data.put(key, new VersionedValue(value, globalVersion.incrementAndGet()));
        }
    }

    public void delete(String key) {
        Transaction transaction = currentTransaction.get();
        if (transaction != null) {
            // Buffer delete in transaction
            transaction.deleteSet.add(key);
            transaction.writeSet.remove(key);
        } else {
            synchronized (data) {
                data.remove(key);
            }
        }
    }

    // Transaction management

    public void begin() {
        if (currentTransaction.get() != null) {
            throw new IllegalStateException("Transaction already in progress");
        }
        currentTransaction.set(new Transaction());
    }

    public boolean commit() {
        Transaction transaction = currentTransaction.get();
        if (transaction == null) {
            throw new IllegalStateException("No active transaction");
        }
        // Validate read set
        for (Map.Entry<String, VersionedValue> entry : transaction.readSet.entrySet()) {
            VersionedValue currentVV = data.get(entry.getKey());
            if (currentVV == null || currentVV.version != entry.getValue().version) {
                // Conflict detected
                currentTransaction.remove();
                return false;
            }
        }

        // Apply changes
        for (String key : transaction.deleteSet) {
            data.remove(key);
        }
        for (Map.Entry<String, String> entry : transaction.writeSet.entrySet()) {
            data.put(entry.getKey(), new VersionedValue(entry.getValue(), globalVersion.incrementAndGet()));
        }

        currentTransaction.remove();
        return true;
    }

    public void rollback() {
        Transaction transaction = currentTransaction.get();
        if (transaction == null) {
            throw new IllegalStateException("No active transaction");
        }
        currentTransaction.remove();
    }


}
