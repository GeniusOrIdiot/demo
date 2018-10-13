package com.example.demo.java_code.alg.tree;

/**
 * All copyright by Liuyajun.
 * <p>
 * Created by mdmor on 2018/10/13
 * </p>
 */
public class BinaryNode<T> {
    T element;
    BinaryNode<T> left;
    BinaryNode<T> right;

    public BinaryNode(T element) {
        this(element, null, null);
    }

    BinaryNode(T element, BinaryNode<T> left, BinaryNode<T> right) {
        this.element = element;
        this.left = left;
        this.right = right;
    }
}
