package ds.stack;

import ds.sequence.ISequence;
import ds.sequence.Sequence1;

public class Stack3<T> implements IStack<T> {

    private final ISequence<T> stackSequence;

    public Stack3() {
        stackSequence = new Sequence1<>();
    }

    @Override
    public void push(T value) {
        stackSequence.add(stackSequence.length(), value);
    }

    @Override
    public T pop() {
        return stackSequence.length() == 0 ? null : stackSequence.remove(stackSequence.length() - 1);
    }

    @Override
    public T peek() {
        return stackSequence.length() == 0 ? null : stackSequence.entry(stackSequence.length() - 1);
    }

    @Override
    public int size() {
        return stackSequence.length();
    }

    @Override
    public boolean isEmpty() {
        return stackSequence.length() == 0;
    }
}