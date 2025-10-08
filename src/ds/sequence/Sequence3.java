package ds.sequence;

import java.util.Stack;

public class Sequence3<T> implements ISequence<T> {

    private final Stack<T> front;
    private final Stack<T> back;

    public Sequence3() {
        front = new Stack<>();
        back = new Stack<>();
    }

    @Override
    public void add(int pos, T x) {
        int len = length();
        if (pos < 0 || pos > len) {
            return;
        }
        for (int i = 0; i < len - pos; i++) {
            front.push(back.pop());
        }
        back.push(x);
        while (!front.isEmpty()) {
            back.push(front.pop());
        }
    }

    @Override
    public T entry(int pos) {
        int len = length();
        if (pos < 0 || pos >= len) {
            return null;
        }
        for (int i = 0; i < len - pos - 1; i++) {
            front.push(back.pop());
        }
        T val = back.peek();
        while (!front.isEmpty()) {
            back.push(front.pop());
        }
        return val;
    }

    @Override
    public int length() {
        return front.size() + back.size();
    }

    @Override
    public T remove(int pos) {
        int len = length();
        if (pos < 0 || pos >= len) {
            return null;
        }
        for (int i = 0; i < len - pos - 1; i++) {
            front.push(back.pop());
        }
        T val = back.pop();
        while (!front.isEmpty()) {
            back.push(front.pop());
        }
        return val;
    }
}