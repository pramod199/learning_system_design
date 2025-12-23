package lld_algomaster.design_bloom_filter;

import lld_algomaster.design_bloom_filter.strategy.HashStrategy;

import java.util.BitSet;
import java.util.List;

public class BloomFilter {
    private final BitSet bitSet;
    private final int bitSetSize;
    private final int numHashFunctions;
    private final List<HashStrategy> hashStrategies;

    public BloomFilter(int bitSetSize, int numHashFunctions, List<HashStrategy> hashStrategies){
        this.bitSetSize = bitSetSize;
        this.numHashFunctions = numHashFunctions;
        this.bitSet = new BitSet(bitSetSize);
        this.hashStrategies = hashStrategies;
    }

    public void add(String item) {
        for (int i = 0; i < numHashFunctions; i++) {
            long hash = hashStrategies.get(i).hash(item);
            int index = (int) (Math.abs(hash) % bitSetSize);
            bitSet.set(index);
        }
    }

    public boolean mightContain(String item) {
        for (int i = 0; i < numHashFunctions; i++) {
            long hash = hashStrategies.get(i).hash(item);
            int index = (int) (Math.abs(hash) % bitSetSize);
            if (!bitSet.get(index)) {
                return false; // Definitely not in the set
            }
        }
        return true; // Might be in the set
    }
}
