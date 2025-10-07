package ds.list;

public interface IList<T> {

    void add(T e);

    void add(int index, T e);

    T get(int index);

    T set(int index, T e);

    T remove(int index);

    boolean remove(T e);

    boolean contains(T e);

    int size();

    boolean isEmpty();
}