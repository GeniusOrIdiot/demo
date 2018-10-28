package com.example.demo.java_code.sort;

import java.util.Arrays;

/**
 * 插入排序：
 * 遍历数组，每次保证遍历到的位置之前是有序的，即将每次遍历到的数插到前面有序的队列中。
 * 测试结果：
 * [22, 13, 57, 82, 35, 4, 16, 80, 23]
 * [13, 22, 57, 82, 35, 4, 16, 80, 23]
 * [13, 22, 57, 82, 35, 4, 16, 80, 23]
 * [13, 22, 57, 82, 35, 4, 16, 80, 23]
 * [13, 22, 35, 57, 82, 4, 16, 80, 23]
 * [4, 13, 22, 35, 57, 82, 16, 80, 23]
 * [4, 13, 16, 22, 35, 57, 82, 80, 23]
 * [4, 13, 16, 22, 35, 57, 80, 82, 23]
 * [4, 13, 16, 22, 23, 35, 57, 80, 82]
 *
 * @author LiuYJ
 * @since 2018/8/17
 */
public class InsertSort extends AbstractSort {

    @Override
    public void sort(int[] arr) {
        System.out.println("================Insert Sorting...================");
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] < arr[j]) {
                    exchange(arr, i, j);
                }
            }
            System.out.println(Arrays.toString(arr));
        }
    }
}
