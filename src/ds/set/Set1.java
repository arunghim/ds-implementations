package ds.set;

import java.util.ArrayList;
import java.util.List;

public class Set1<T> implements ISet<T> {

    private final List<T> setList;

    public Set1() {
        this.setList = new ArrayList<>();
    }

    @Override
    public boolean add(T value) {
        return !setList.contains(value) ? setList.add(value) : false;
    }

    @Override
    public boolean remove(T value) {
        return setList.contains(value) ? setList.remove(value) : false;
    }

    @Override
    public boolean contains(T value) {
        return setList.contains(value);
    }

    @Override
    public int size() {
        return setList.size();
    }

    @Override
    public boolean isEmpty() {
        return setList.isEmpty();
    }
}