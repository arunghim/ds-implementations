package ds.tree;

import java.util.ArrayList;
import java.util.List;


public class BinarySearchTree<T extends Comparable<T>> implements ITree<T> {

    Node<T> root;

    public BinarySearchTree() {
        root = null;
    }

    @Override
    public boolean insert(T value) {
        if (value == null) {
            return false;
        }
        int oldSize = size();
        root = helpInsert(root, value);
        return size() > oldSize;
    }

    @Override
    public boolean remove(T value) {
        if (value == null || !contains(value)) {
            return false;
        }
        root = helpRemove(root, value);
        return true;
    }

    @Override
    public boolean contains(T value) {
        if (value == null) {
            return false;
        }
        return helpSearch(root, value);
    }

    @Override
    public int size() {
        return helpSize(root);
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public T findMin() {
        if (root == null) {
            return null;
        }
        return helpFindMin(root);
    }

    @Override
    public T findMax() {
        if (root == null) {
            return null;
        }
        return helpFindMax(root);
    }

    private Node<T> helpInsert(Node<T> node, T value) {
        if (node == null) {
            return new Node<>(value);
        }
        if (value.compareTo(node.value) < 0) {
            node.left = helpInsert(node.left, value);
        } else if (value.compareTo(node.value) > 0) {
            node.right = helpInsert(node.right, value);
        }
        return node;
    }

    private Node<T> helpRemove(Node<T> node, T value) {
        if (node == null) {
            return null;
        }
        int cmp = value.compareTo(node.value);
        if (cmp < 0) {
            node.left = helpRemove(node.left, value);
        } else if (cmp > 0) {
            node.right = helpRemove(node.right, value);
        } else {
            if (node.left == null) {
                return node.right;
            }
            if (node.right == null) {
                return node.left;
            }
            node.value = helpFindMin(node.right);
            node.right = helpRemove(node.right, node.value);
        }
        return node;
    }

    private boolean helpSearch(Node<T> node, T value) {
        if (node == null) {
            return false;
        }
        if (node.value.compareTo(value) == 0) {
            return true;
        }
        if (value.compareTo(node.value) < 0) {
            return helpSearch(node.left, value);
        } else {
            return helpSearch(node.right, value);
        }
    }

    private int helpSize(Node<T> node) {
        if (node == null) {
            return 0;
        }
        return 1 + helpSize(node.left) + helpSize(node.right);
    }

    private T helpFindMin(Node<T> node) {
        if (node == null) {
            return null;
        }
        if (node.left == null) {
            return node.value;
        }
        return helpFindMin(node.left);
    }

    private T helpFindMax(Node<T> node) {
        if (node == null) {
            return null;
        }
        if (node.right == null) {
            return node.value;
        }
        return helpFindMax(node.right);
    }

    private void helpInOrder(Node<T> node, List<T> result) {
        if (node != null) {
            helpInOrder(node.left, result);
            result.add(node.value);
            helpInOrder(node.right, result);
        }
    }

    public List<T> inOrder() {
        List<T> result = new ArrayList<>();
        helpInOrder(root, result);
        return result;
    }
}