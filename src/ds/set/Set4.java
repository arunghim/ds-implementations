package ds.set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Set4<T> implements ISet<T> {

    private List<Set<T>> buckets;
    private int capacity;
    private int size;
    private static final double LOAD_FACTOR = 0.75;

    public Set4() {
        this.capacity = 16;
        this.buckets = new ArrayList<>(capacity);
        for (int i = 0; i < capacity; i++) {
            buckets.add(new HashSet<>());
        }
        this.size = 0;
    }

    private int getBucketIndex(T value) {
        return (value == null ? 0 : Math.abs(value.hashCode())) % capacity;
    }

    @Override
    public boolean add(T value) {
        if (contains(value)) {
            return false;
        }
        if ((size + 1.0) / capacity > LOAD_FACTOR) {
            resize();
        }
        int index = getBucketIndex(value);
        if (buckets.get(index).add(value)) {
            size++;
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(T value) {
        int index = getBucketIndex(value);
        if (buckets.get(index).remove(value)) {
            size--;
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(T value) {
        int index = getBucketIndex(value);
        return buckets.get(index).contains(value);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private void resize() {
        int newCapacity = capacity * 2;
        List<Set<T>> newBuckets = new ArrayList<>(newCapacity);
        for (int i = 0; i < newCapacity; i++) {
            newBuckets.add(new HashSet<>());
        }

        for (Set<T> bucket : buckets) {
            for (T value : bucket) {
                int index = (value == null ? 0 : Math.abs(value.hashCode())) % newCapacity;
                newBuckets.get(index).add(value);
            }
        }

        capacity = newCapacity;
        buckets = newBuckets;
    }
}