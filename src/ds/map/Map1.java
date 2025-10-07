package ds.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Map1<T> implements IMap<T, T> {

    private final Map<T, T> map;

    public Map1() {
        map = new HashMap<>();
    }

    @Override
    public T put(T key, T value) {
        return map.put(key, value);
    }

    @Override
    public T get(T key) {
        return map.get(key);
    }

    @Override
    public T remove(T key) {
        return map.remove(key);
    }

    @Override
    public boolean containsKey(T key) {
        return map.containsKey(key);
    }

    @Override
    public boolean containsValue(T value) {
        return map.containsValue(value);
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public Set<T> keySet() {
        return map.keySet();
    }
}