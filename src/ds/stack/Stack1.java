package ds.stack;

import java.util.List;
import java.util.ArrayList;

public class Stack1<T> implements IStack<T> {

    private final List<T> stackList;

    public Stack1() {
        stackList = new ArrayList<>();
    }

    @Override
    public void push(T value) {
        stackList.add(value);
    }

    @Override
    public T pop() {
        return stackList.isEmpty() ? null : stackList.remove(stackList.size() - 1);
    }

    @Override
    public T peek() {
        return stackList.isEmpty() ? null : stackList.get(stackList.size() - 1);
    }

    @Override
    public int size() {
        return stackList.size();
    }

    @Override
    public boolean isEmpty() {
        return stackList.isEmpty();
    }
}