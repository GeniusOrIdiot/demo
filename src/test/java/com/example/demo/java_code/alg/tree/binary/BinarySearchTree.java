package com.example.demo.java_code.alg.tree.binary;

import java.util.Comparator;

/**
 * All copyright by Liuyajun.
 * <p>
 * Created by mdmor on 2018/10/13
 * </p>
 */
public class BinarySearchTree<T extends Comparable<T>> {
    private BinaryNode<T> root;
    private Comparator<? super T> comp;

    public BinarySearchTree() {
        this(null);
    }

    public BinarySearchTree(Comparator<? super T> comp) {
        this.root = null;
        this.comp = comp;
    }

    public void makeEmpty() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean contains(T x) {
        return contains(x, root);
    }

    public BinaryNode<T> insert(T x) {
        return root = insert(x, root);
    }

    public BinaryNode<T> remove(T x) {
        return root = remove(x, root);
    }

    private int compare(T lhs, T rhs) {
        if (this.comp != null) {
            return comp.compare(lhs, rhs);
        }

        return lhs.compareTo(rhs);
    }

    private boolean contains(T x, BinaryNode<T> node) {
        if (node == null || x == null) return false;

        int compareResult = compare(x, node.element);
        if (compareResult > 0) {
            return contains(x, node.right);
        } else if (compareResult < 0) {
            return contains(x, node.left);
        } else return true;
    }

    private BinaryNode<T> findMin(BinaryNode<T> node) {
        if (node == null) {
            return null;
        } else if (node.left == null) {
            return node;
        } else return findMin(node.left);
    }

    private BinaryNode<T> findMax(BinaryNode<T> node) {
        BinaryNode<T> maxNode = node;
        if (maxNode != null) {
            while (maxNode.right != null) {
                maxNode = maxNode.right;
            }
        }
        return maxNode;
    }

    private BinaryNode<T> insert(T x, BinaryNode<T> node) {
        if (node == null) {
            node = new BinaryNode<>(x);
            return node;
        }

        int compareResult = compare(x, node.element);
        if (compareResult > 0) {
            node.right = insert(x, node.right);
        } else if (compareResult < 0) {
            node.left = insert(x, node.left);
        }
        return node;
    }

    private BinaryNode<T> remove(T x, BinaryNode<T> node) {
        if (node == null) return null;

        int compareResult = compare(x, node.element);
        if (compareResult > 0) {
            node.right = remove(x, node.right);
        } else if (compareResult < 0) {
            node.left = remove(x, node.left);
        } else if (node.left != null && node.right != null) {
            node.element = findMin(node.right).element;
            node.right = remove(node.element, node.right);
        } else
            node = node.left != null ? node.left : node.right;
        return node;
    }

    private static class BinaryNode<T> {
        T element;
        BinaryNode<T> left;
        BinaryNode<T> right;

        BinaryNode(T element) {
            this(element, null, null);
        }

        BinaryNode(T element, BinaryNode<T> left, BinaryNode<T> right) {
            this.element = element;
            this.left = left;
            this.right = right;
        }
    }
}
