package ds.stack;

public interface IStack<T> {

    void push(T e);

    T pop();

    T peek();

    int size();

    boolean isEmpty();
}