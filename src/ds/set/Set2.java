package ds.set;

import java.util.HashMap;
import java.util.Map;

public class Set2<T> implements ISet<T> {

    private final Map<T, T> setMap;
    private final T DUMMY = null;

    public Set2() {
        this.setMap = new HashMap<>();
    }

    @Override
    public boolean add(T value) {
        return !setMap.containsKey(value) ? setMap.put(value, DUMMY) == null : false;
    }

    @Override
    public boolean remove(T value) {
        return setMap.remove(value) != null;
    }

    @Override
    public boolean contains(T value) {
        return setMap.containsKey(value);
    }

    @Override
    public int size() {
        return setMap.size();
    }

    @Override
    public boolean isEmpty() {
        return setMap.isEmpty();
    }
}