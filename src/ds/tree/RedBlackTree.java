package ds.tree;

public class RedBlackTree<T extends Comparable<T>> implements ITree<T> {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private static class Node<T> {
        T value;
        Node<T> left, right;
        boolean color;
        Node(T value, boolean color) {
            this.value = value;
            this.color = color;
        }
    }

    private Node<T> root;
    private int size = 0;

    @Override
    public boolean insert(T value) {
        if (value == null) return false;
        if (!contains(value)) {
            root = insert(root, value);
            root.color = BLACK;
            size++;
            return true;
        }
        return false;
    }

    private Node<T> insert(Node<T> h, T value) {
        if (h == null) return new Node<>(value, RED);
        int cmp = value.compareTo(h.value);
        if (cmp < 0) h.left = insert(h.left, value);
        else if (cmp > 0) h.right = insert(h.right, value);
        if (isRed(h.right) && !isRed(h.left)) h = rotateLeft(h);
        if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
        if (isRed(h.left) && isRed(h.right)) flipColors(h);
        return h;
    }

    @Override
    public boolean remove(T value) {
        if (value == null || !contains(value)) return false;
        if (!isRed(root.left) && !isRed(root.right)) root.color = RED;
        root = remove(root, value);
        if (root != null) root.color = BLACK;
        size--;
        return true;
    }

    private Node<T> remove(Node<T> h, T value) {
        if (value.compareTo(h.value) < 0) {
            if (!isRed(h.left) && !isRed(h.left == null ? null : h.left.left))
                h = moveRedLeft(h);
            h.left = remove(h.left, value);
        } else {
            if (isRed(h.left)) h = rotateRight(h);
            if (value.compareTo(h.value) == 0 && h.right == null) return null;
            if (!isRed(h.right) && !isRed(h.right == null ? null : h.right.left))
                h = moveRedRight(h);
            if (value.compareTo(h.value) == 0) {
                Node<T> x = min(h.right);
                h.value = x.value;
                h.right = deleteMin(h.right);
            } else h.right = remove(h.right, value);
        }
        return balance(h);
    }

    private Node<T> deleteMin(Node<T> h) {
        if (h.left == null) return null;
        if (!isRed(h.left) && !isRed(h.left.left))
            h = moveRedLeft(h);
        h.left = deleteMin(h.left);
        return balance(h);
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
        Node<T> n = min(root);
        return n == null ? null : n.value;
    }

    @Override
    public T findMax() {
        Node<T> n = root;
        if (n == null) return null;
        while (n.right != null) n = n.right;
        return n.value;
    }

    private Node<T> min(Node<T> n) {
        if (n == null) return null;
        while (n.left != null) n = n.left;
        return n;
    }

    private boolean isRed(Node<T> n) {
        return n != null && n.color == RED;
    }

    private Node<T> rotateLeft(Node<T> h) {
        Node<T> x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    private Node<T> rotateRight(Node<T> h) {
        Node<T> x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    private void flipColors(Node<T> h) {
        h.color = !h.color;
        if (h.left != null) h.left.color = !h.left.color;
        if (h.right != null) h.right.color = !h.right.color;
    }

    private Node<T> moveRedLeft(Node<T> h) {
        flipColors(h);
        if (isRed(h.right.left)) {
            h.right = rotateRight(h.right);
            h = rotateLeft(h);
            flipColors(h);
        }
        return h;
    }

    private Node<T> moveRedRight(Node<T> h) {
        flipColors(h);
        if (isRed(h.left.left)) {
            h = rotateRight(h);
            flipColors(h);
        }
        return h;
    }

    private Node<T> balance(Node<T> h) {
        if (isRed(h.right)) h = rotateLeft(h);
        if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
        if (isRed(h.left) && isRed(h.right)) flipColors(h);
        return h;
    }
}