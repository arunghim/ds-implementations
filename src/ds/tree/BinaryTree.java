package ds.tree;

import java.util.LinkedList;
import java.util.Queue;


public class BinaryTree<T extends Comparable<T>> implements ITree<T> {

    private Node<T> root;
    private int size = 0;

    @Override
    public boolean insert(T value) {
        if (value == null) return false;
        Node<T> newNode = new Node<>(value);
        if (root == null) {
            root = newNode;
            size++;
            return true;
        }
        Queue<Node<T>> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node<T> current = q.poll();
            if (current.left == null) {
                current.left = newNode;
                size++;
                return true;
            } else q.add(current.left);
            if (current.right == null) {
                current.right = newNode;
                size++;
                return true;
            } else q.add(current.right);
        }
        return false;
    }

    @Override
    public boolean remove(T value) {
        if (root == null || value == null) return false;
        Queue<Node<T>> q = new LinkedList<>();
        q.add(root);
        Node<T> target = null, last = null, parentOfLast = null;
        while (!q.isEmpty()) {
            Node<T> current = q.poll();
            if (current.value.equals(value)) target = current;
            if (current.left != null) {
                parentOfLast = current;
                last = current.left;
                q.add(current.left);
            }
            if (current.right != null) {
                parentOfLast = current;
                last = current.right;
                q.add(current.right);
            }
        }
        if (target == null) return false;
        if (last != null) target.value = last.value;
        if (parentOfLast != null) {
            if (parentOfLast.right == last) parentOfLast.right = null;
            else parentOfLast.left = null;
        } else root = null;
        size--;
        return true;
    }

    @Override
    public boolean contains(T value) {
        if (root == null || value == null) return false;
        Queue<Node<T>> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node<T> current = q.poll();
            if (current.value.equals(value)) return true;
            if (current.left != null) q.add(current.left);
            if (current.right != null) q.add(current.right);
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
        if (root == null) return null;
        Queue<Node<T>> q = new LinkedList<>();
        q.add(root);
        T min = root.value;
        while (!q.isEmpty()) {
            Node<T> current = q.poll();
            if (current.value.compareTo(min) < 0) min = current.value;
            if (current.left != null) q.add(current.left);
            if (current.right != null) q.add(current.right);
        }
        return min;
    }

    @Override
    public T findMax() {
        if (root == null) return null;
        Queue<Node<T>> q = new LinkedList<>();
        q.add(root);
        T max = root.value;
        while (!q.isEmpty()) {
            Node<T> current = q.poll();
            if (current.value.compareTo(max) > 0) max = current.value;
            if (current.left != null) q.add(current.left);
            if (current.right != null) q.add(current.right);
        }
        return max;
    }
}