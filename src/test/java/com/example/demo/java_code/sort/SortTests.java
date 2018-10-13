package com.example.demo.java_code.sort;

import com.example.demo.java_code.Cell;

import java.util.*;

/**
 * 排序算法统一测试
 *
 * @author LiuYJ
 * @since 2018/8/17
 */
public class SortTests {
    public static void main(String[] args) {
        int[] arr = {22, 13, 57, 82, 35, 4, 16, 80, 23};
        Sort selectSort = new SelectSort();
        selectSort.sort(arr);

        Sort insertSort = new InsertSort();
        insertSort.sort(arr);

        Sort shellSort = new ShellSort();
        shellSort.sort(arr);

        List<Cell> cells = new ArrayList<>();
        cells.add(new Cell("a", 15));
        cells.add(new Cell("b", 12));
        cells.add(new Cell("c", 13));
        cells.sort(Comparator.comparingInt(Cell::getAge));
        System.out.println(cells);
    }
}
