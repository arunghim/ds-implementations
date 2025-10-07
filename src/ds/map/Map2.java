package ds.map;

import java.util.LinkedList;
import java.util.Queue;
import java.util.HashSet;
import java.util.Set;

public class Map2<K, V> implements IMap<K, V> {

    private final Queue<K> keyQueue;
    private final Queue<V> valueQueue;

    public Map2() {
        keyQueue = new LinkedList<>();
        valueQueue = new LinkedList<>();
    }

    @Override
    public V put(K key, V value) {
        int index = findKeyIndex(key);
        if (index != -1) {
            V oldValue = get(key);
            replaceAtIndex(valueQueue, index, value);
            return oldValue;
        } else {
            keyQueue.add(key);
            valueQueue.add(value);
            return null;
        }
    }

    @Override
    public V get(K key) {
        int index = findKeyIndex(key);
        if (index == -1) {
            return null;
        }
        return getAtIndex(valueQueue, index);
    }

    @Override
    public V remove(K key) {
        int index = findKeyIndex(key);
        if (index == -1) {
            return null;
        }
        V value = getAtIndex(valueQueue, index);
        removeAtIndex(keyQueue, index);
        removeAtIndex(valueQueue, index);
        return value;
    }

    @Override
    public boolean containsKey(K key) {
        return findKeyIndex(key) != -1;
    }

    @Override
    public boolean containsValue(V value) {
        return valueQueue.contains(value);
    }

    @Override
    public int size() {
        return keyQueue.size();
    }

    @Override
    public boolean isEmpty() {
        return keyQueue.isEmpty();
    }

    @Override
    public Set<K> keySet() {
        return new HashSet<>(keyQueue);
    }

    private int findKeyIndex(K key) {
        int i = 0;
        for (K k : keyQueue) {
            if ((k == null && key == null) || (k != null && k.equals(key))) {
                return i;
            }
            i++;
        }
        return -1;
    }

    private <T> T getAtIndex(Queue<T> queue, int index) {
        int i = 0;
        for (T item : queue) {
            if (i == index) {
                return item;
            }
            i++;
        }
        return null;
    }

    private <T> void removeAtIndex(Queue<T> queue, int index) {
        Queue<T> temp = new LinkedList<>();
        int i = 0;
        for (T item : queue) {
            if (i != index) {
                temp.add(item);
            }
            i++;
        }
        queue.clear();
        queue.addAll(temp);
    }

    private <T> void replaceAtIndex(Queue<T> queue, int index, T newValue) {
        Queue<T> temp = new LinkedList<>();
        int i = 0;
        for (T item : queue) {
            temp.add(i == index ? newValue : item);
            i++;
        }
        queue.clear();
        queue.addAll(temp);
    }
}