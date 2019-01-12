package com.example.demo.java_code.alg.tree.binary;

import com.example.demo.java_code.obj.Cell;

/**
 * All copyright by MDMORY.
 *
 * @author LiuYajun
 * @since 19-1-12 下午12:56
 */
public class BinaryTreeTest {
    public static void main(String[] args) {
        BinarySearchTree<Cell> cellTree = new BinarySearchTree<>();
        cellTree.insert(new Cell("Allen", 12));
        cellTree.insert(new Cell("Bob", 7));
        cellTree.insert(new Cell("Coke", 18));

        cellTree.contains(new Cell("Death", 18));
        cellTree.remove(new Cell("Flower", 12));
    }
}
