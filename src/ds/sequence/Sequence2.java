package ds.sequence;

import java.util.LinkedList;
import java.util.List;

public class Sequence2<T> implements ISequence<T> {

    private final List<T> sequenceList;

    public Sequence2() {
        sequenceList = new LinkedList<>();
    }

    @Override
    public void add(int pos, T x) {
        if (pos < 0 || pos > sequenceList.size()) {
            return;
        }
        sequenceList.add(pos, x);
    }

    @Override
    public T entry(int pos) {
        return (pos < 0 || pos >= sequenceList.size()) ? null : sequenceList.get(pos);
    }

    @Override
    public T remove(int pos) {
        return (pos < 0 || pos >= sequenceList.size()) ? null : sequenceList.remove(pos);
    }

    @Override
    public int length() {
        return sequenceList.size();
    }

}