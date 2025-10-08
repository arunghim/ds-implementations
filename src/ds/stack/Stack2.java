package ds.stack;

import java.util.LinkedList;

public class Stack2<T> implements IStack<T> {

    LinkedList<T> stackList;

    public Stack2() {
        stackList = new LinkedList<>();
    }

    @Override
    public void push(T value) {
        stackList.addLast(value);
    }

    @Override
    public T pop() {
        return stackList.isEmpty() ? null : stackList.removeLast();
    }

    @Override
    public T peek() {
        return stackList.isEmpty() ? null : stackList.getLast();
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