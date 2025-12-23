package lld_algomaster.design_lru_cache;

public class Node <K, V> {
    K key;

    V value;

    Node<K, V> prev, next;

    public Node(K key, V value) {
        this.key = key;
        this.value = value;
    }


}
