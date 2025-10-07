package ds.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Map3<K, V> implements IMap<K, V> {

    private final Map<K, V>[] buckets;
    private final int capacity;

    @SuppressWarnings("unchecked")
    public Map3(int capacity) {
        this.capacity = capacity == 0 ? 16 : capacity;
        this.buckets = (Map<K, V>[]) new HashMap[this.capacity];
        for (int i = 0; i < this.capacity; i++) {
            buckets[i] = new HashMap<>();
        }
    }

    private int getBucketIndex(K key) {
        return (key == null ? 0 : key.hashCode() & 0x7FFFFFFF) % capacity;
    }

    @Override
    public V put(K key, V value) {
        int index = getBucketIndex(key);
        return buckets[index].put(key, value);
    }

    @Override
    public V get(K key) {
        int index = getBucketIndex(key);
        return buckets[index].get(key);
    }

    @Override
    public V remove(K key) {
        int index = getBucketIndex(key);
        return buckets[index].remove(key);
    }

    @Override
    public boolean containsKey(K key) {
        int index = getBucketIndex(key);
        return buckets[index].containsKey(key);
    }

    @Override
    public boolean containsValue(V value) {
        for (Map<K, V> bucket : buckets) {
            if (bucket.containsValue(value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        int total = 0;
        for (Map<K, V> bucket : buckets) {
            total += bucket.size();
        }
        return total;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public Set<K> keySet() {
        Set<K> keys = new HashMap<K, V>().keySet();
        for (Map<K, V> bucket : buckets) {
            keys.addAll(bucket.keySet());
        }
        return keys;
    }
}