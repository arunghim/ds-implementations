package ds.sequence;

public interface ISequence<T> {

    void add(int pos, T x);

    T entry(int pos);

    int length();

    T remove(int pos);
}