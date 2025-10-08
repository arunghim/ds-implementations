package ds.map;

import ds.tree.BinarySearchTree;
import java.util.Set;
import java.util.HashSet;

public class Map4<K extends Comparable<K>, V> implements IMap<K, V> {

    private static class Pair<K extends Comparable<K>, V> implements Comparable<Pair<K, V>> {

        K key;
        V value;

        Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public int compareTo(Pair<K, V> other) {
            return key.compareTo(other.key);
        }
    }

    private final BinarySearchTree<Pair<K, V>> tree;

    public Map4() {
        tree = new BinarySearchTree<>();
    }

    @Override
    public V put(K key, V value) {
        Pair<K, V> pair = new Pair<>(key, value);
        for (Pair<K, V> p : tree.inOrder()) {
            if (p.key.equals(key)) {
                V old = p.value;
                p.value = value;
                return old;
            }
        }
        tree.insert(pair);
        return null;
    }

    @Override
    public V get(K key) {
        for (Pair<K, V> p : tree.inOrder()) {
            if (p.key.equals(key)) {
                return p.value;
            }
        }
        return null;
    }

    @Override
    public V remove(K key) {
        for (Pair<K, V> p : tree.inOrder()) {
            if (p.key.equals(key)) {
                V value = p.value;
                tree.remove(p);
                return value;
            }
        }
        return null;
    }

    @Override
    public boolean containsKey(K key) {
        for (Pair<K, V> p : tree.inOrder()) {
            if (p.key.equals(key)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsValue(V value) {
        for (Pair<K, V> p : tree.inOrder()) {
            if ((value == null && p.value == null) || (value != null && value.equals(p.value))) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return tree.size();
    }

    @Override
    public boolean isEmpty() {
        return tree.isEmpty();
    }

    @Override
    public Set<K> keySet() {
        Set<K> keys = new HashSet<>();
        for (Pair<K, V> p : tree.inOrder()) {
            keys.add(p.key);
        }
        return keys;
    }
}