package lld_algomaster.design_bloom_filter;

import lld_algomaster.design_bloom_filter.enums.HashType;
import lld_algomaster.design_bloom_filter.strategy.DJB2HashStrategy;
import lld_algomaster.design_bloom_filter.strategy.FNV1aHashStrategy;
import lld_algomaster.design_bloom_filter.strategy.HashStrategy;

public class HashStrategyFactory {
    public static HashStrategy create(HashType type) {
        switch (type) {
            case FNV1A:
                return new FNV1aHashStrategy();
            case DJB2:
                return new DJB2HashStrategy();
            default:
                throw new IllegalArgumentException("Unsupported hash type: " + type);
        }
    }
}
