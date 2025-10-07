package ds.map;

import java.util.Set;

public interface IMap<K, V> {

    V put(K key, V value);

    V get(K key);

    V remove(K key);

    boolean containsKey(K key);

    boolean containsValue(V v);

    int size();

    boolean isEmpty();

    Set<K> keySet();
}