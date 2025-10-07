package ds.set;

public interface ISet<T> {

    boolean add(T e);

    boolean remove(T e);

    boolean contains(T e);

    int size();

    boolean isEmpty();
}