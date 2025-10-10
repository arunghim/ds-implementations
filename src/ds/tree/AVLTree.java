package ds.tree;

public class AVLTree<T extends Comparable<T>> implements ITree<T> {

    private static class Node<T> {
        T value;
        Node<T> left, right;
        int height = 1;
        Node(T value) { this.value = value; }
    }

    private Node<T> root;
    private int size = 0;

    @Override
    public boolean insert(T value) {
        if (value == null) return false;
        if (!contains(value)) {
            root = insert(root, value);
            size++;
            return true;
        }
        return false;
    }

    private Node<T> insert(Node<T> node, T value) {
        if (node == null) return new Node<>(value);
        int cmp = value.compareTo(node.value);
        if (cmp < 0) node.left = insert(node.left, value);
        else if (cmp > 0) node.right = insert(node.right, value);
        updateHeight(node);
        return balance(node);
    }

    @Override
    public boolean remove(T value) {
        if (value == null || !contains(value)) return false;
        root = remove(root, value);
        size--;
        return true;
    }

    private Node<T> remove(Node<T> node, T value) {
        if (node == null) return null;
        int cmp = value.compareTo(node.value);
        if (cmp < 0) node.left = remove(node.left, value);
        else if (cmp > 0) node.right = remove(node.right, value);
        else {
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;
            Node<T> min = findMinNode(node.right);
            node.value = min.value;
            node.right = remove(node.right, min.value);
        }
        updateHeight(node);
        return balance(node);
    }

    @Override
    public boolean contains(T value) {
        Node<T> cur = root;
        while (cur != null) {
            int cmp = value.compareTo(cur.value);
            if (cmp == 0) return true;
            cur = cmp < 0 ? cur.left : cur.right;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public T findMin() {
        Node<T> min = findMinNode(root);
        return min == null ? null : min.value;
    }

    @Override
    public T findMax() {
        Node<T> cur = root;
        if (cur == null) return null;
        while (cur.right != null) cur = cur.right;
        return cur.value;
    }

    private Node<T> findMinNode(Node<T> node) {
        if (node == null) return null;
        while (node.left != null) node = node.left;
        return node;
    }

    private void updateHeight(Node<T> n) {
        n.height = 1 + Math.max(height(n.left), height(n.right));
    }

    private int height(Node<T> n) {
        return n == null ? 0 : n.height;
    }

    private int balanceFactor(Node<T> n) {
        return height(n.left) - height(n.right);
    }

    private Node<T> balance(Node<T> n) {
        int bf = balanceFactor(n);
        if (bf > 1) {
            if (balanceFactor(n.left) < 0) n.left = rotateLeft(n.left);
            return rotateRight(n);
        }
        if (bf < -1) {
            if (balanceFactor(n.right) > 0) n.right = rotateRight(n.right);
            return rotateLeft(n);
        }
        return n;
    }

    private Node<T> rotateRight(Node<T> y) {
        Node<T> x = y.left;
        Node<T> t = x.right;
        x.right = y;
        y.left = t;
        updateHeight(y);
        updateHeight(x);
        return x;
    }

    private Node<T> rotateLeft(Node<T> x) {
        Node<T> y = x.right;
        Node<T> t = y.left;
        y.left = x;
        x.right = t;
        updateHeight(x);
        updateHeight(y);
        return y;
    }
}