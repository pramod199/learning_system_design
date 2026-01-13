package machine_coding.inmemory_key_value_store;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Transaction {
    Map<String, VersionedValue> readSet = new HashMap<>();
    Map<String, String> writeSet = new HashMap<>();
    Set<String> deleteSet = new HashSet<>();
}