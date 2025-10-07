package ds.tree;

public interface ITree<T extends Comparable<T>> {

    boolean insert(T value);

    boolean remove(T value);

    boolean contains(T value);

    int size();

    boolean isEmpty();

    T findMin();

    T findMax();
}