package ds.queue;

import java.util.ArrayList;
import java.util.List;

public class Queue1<T> implements IQueue<T> {

    private final List<T> queueList;

    public Queue1() {
        queueList = new ArrayList<>();
    }

    @Override
    public boolean offer(T value) {
        return queueList.add(value);
    }

    @Override
    public T poll() {
        return queueList.isEmpty() ? null : queueList.remove(0);
    }

    @Override
    public T peek() {
        return queueList.isEmpty() ? null : queueList.get(0);
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