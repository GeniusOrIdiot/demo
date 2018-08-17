package com.example.demo.java_code.sort;

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
    }
}
