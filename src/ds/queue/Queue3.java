package ds.queue;

import ds.sequence.ISequence;
import ds.sequence.Sequence1;

public class Queue3<T> implements IQueue<T> {

    private final ISequence<T> queueSequence;

    public Queue3() {
        queueSequence = new Sequence1<>();
    }

    @Override
    public boolean offer(T value) {
        queueSequence.add(queueSequence.length(), value);
        return true;
    }

    @Override
    public T poll() {
        return queueSequence.length() == 0 ? null : queueSequence.remove(0);
    }

    @Override
    public T peek() {
        return queueSequence.length() == 0 ? null : queueSequence.entry(0);
    }

    @Override
    public int size() {
        return queueSequence.length();
    }

    @Override
    public boolean isEmpty() {
        return queueSequence.length() == 0;
    }
}