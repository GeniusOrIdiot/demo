package com.example.demo.java_code.alg.tree.avl;

import java.util.Comparator;

/**
 * All copyright by MDMORY.
 *
 * @author LiuYajun
 * @since 19-1-12 下午12:56
 */
public class AvlTree<T extends Comparable<T>> {

    private AvlNode<T> root;
    private Comparator<T> comp;

    public AvlTree() {
        this(null);
    }

    public AvlTree(Comparator<T> comp) {
        this.root = null;
        this.comp = comp;
    }

    /**
     * Insert item x into this avl tree.
     */
    public AvlNode<T> insert(T x) {
        return root = insert(x, root);
    }

    private AvlNode<T> insert(T x, AvlNode<T> node) {
        if (node == null) return new AvlNode<>(x);

        int compareResult = compare(x, node.element);
        if (compareResult > 0) {
            node.right = insert(x, node.right);
            if (height(node.right) - height(node.left) == 2) {
                if (compare(x, node.right.element) > 0)
                    node = rotateWithRightChild(node);
                else
                    node = doubleWithRightChild(node);
            }
        } else if (compareResult < 0) {
            node.left = insert(x, node.left);
            if (height(node.left) - height(node.right) == 2)
                if (compare(x, node.left.element) < 0)
                    node = rotateWithLeftChild(node);
                else
                    node = doubleWithLeftChild(node);
        } else return node;

        node.h = Math.max(height(node.left), height(node.right)) + 1;

        return node;
    }

    /**
     * 左子树双旋转
     */
    private AvlNode<T> doubleWithLeftChild(AvlNode<T> node) {
        /*
        AvlNode<T> n1 = node.left;
        AvlNode<T> n2 = n1.right;
        node.left = n2.right;
        n1.right = n2.left;
        n2.right = node;
        n2.left = n1;
        return n2;
        */
        node.left = rotateWithLeftChild(node.left);
        return rotateWithLeftChild(node);
    }

    /**
     * 左子树单旋转
     */
    private AvlNode<T> rotateWithLeftChild(AvlNode<T> node) {
        AvlNode<T> left = node.left;
        node.left = left.right;
        left.right = node;
        /*node.h -= 1;*/
        setHeight(node);
        setHeight(left);
        return left;
    }

    /**
     * 右子树双旋转
     */
    private AvlNode<T> doubleWithRightChild(AvlNode<T> node) {
        /*
        AvlNode<T> n1 = node.right;
        AvlNode<T> n2 = n1.left;
        node.right = n2.left;
        n1.left = n2.right;
        n2.left = node;
        n2.right = n1;
        node.h -= 1;
        n1.h += 1;
        n2.h += 1;
        return n2;
        */
        node.right = rotateWithRightChild(node.right);
        return rotateWithRightChild(node);
    }

    /**
     * 右子树单旋转
     */
    private AvlNode<T> rotateWithRightChild(AvlNode<T> node) {
        AvlNode<T> right = node.right;
        node.right = right.left;
        right.left = node;
        /*node.h -= 1;*/
        setHeight(node);
        setHeight(right);
        return right;
    }

    private int compare(T lhs, T rhs) {
        if (this.comp != null) {
            return comp.compare(lhs, rhs);
        }

        return lhs.compareTo(rhs);
    }

    private int height(AvlNode<T> node) {
        return node == null ? -1 : node.h;
    }

    private void setHeight(AvlNode<T> node) {
        node.h = Math.max(height(node.left), height(node.right)) + 1;
    }

    private static class AvlNode<T extends Comparable<T>> {
        T element;
        AvlNode<T> left;
        AvlNode<T> right;
        int h;

        AvlNode(T element) {
            this(element, null, null);
        }

        AvlNode(T element, AvlNode<T> left, AvlNode<T> right) {
            this.element = element;
            this.left = left;
            this.right = right;
        }
    }
}
