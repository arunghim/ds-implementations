package ds.set;

import ds.tree.BinaryTree;

public class Set3<T extends Comparable<T>> implements ISet<T> {

    BinaryTree<T> setTree;

    public Set3() {
        setTree = new BinaryTree<>();
    }

    @Override
    public boolean add(T value) {
        return !setTree.contains(value) ? setTree.insert(value) : false;
    }

    @Override
    public boolean remove(T value) {
        return setTree.remove(value);
    }

    @Override
    public boolean contains(T value) {
        return setTree.contains(value);
    }

    @Override
    public int size() {
        return setTree.size();
    }

    @Override
    public boolean isEmpty() {
        return setTree.isEmpty();
    }
}