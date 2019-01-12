package com.example.demo.java_code.alg.tree.avl;

/**
 * All copyright by MDMORY.
 *
 * @author LiuYajun
 * @since 19-1-12 下午12:56
 */
public class AvlTreeTest {
    public static void main(String[] args) {
        AvlTree<Integer> cellTree = new AvlTree<>();
        cellTree.insert(3);
        cellTree.insert(2);
        cellTree.insert(1);
        cellTree.insert(4);
        cellTree.insert(5);
        cellTree.insert(6);
        cellTree.insert(7);
    }
}
