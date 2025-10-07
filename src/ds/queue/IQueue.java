package ds.queue;

public interface IQueue<T> {

    boolean offer(T e);

    T poll();

    T peek();

    int size();

    boolean isEmpty();
}