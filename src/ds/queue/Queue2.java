package ds.queue;

import java.util.LinkedList;

public class Queue2<T> implements IQueue<T> {

    private final LinkedList<T> queueList;

    public Queue2() {
        queueList = new LinkedList<>();
    }

    @Override
    public boolean offer(T value) {
        return queueList.add(value);
    }

    @Override
    public T poll() {
        return queueList.isEmpty() ? null : queueList.removeFirst();
    }

    @Override
    public T peek() {
        return queueList.isEmpty() ? null : queueList.getFirst();
    }

    @Override
    public int size() {
        return queueList.size();
    }

    @Override
    public boolean isEmpty() {
        return queueList.isEmpty();
    }
}