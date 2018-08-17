package com.example.demo.java_code.sort;

import java.util.Arrays;

/**
 * 选择排序：
 * 遍历数组，与之后的所有数比较，每次将最小的数交换到开头。
 * 测试结果：
 * [4, 13, 57, 82, 35, 22, 16, 80, 23]
 * [4, 13, 57, 82, 35, 22, 16, 80, 23]
 * [4, 13, 16, 82, 35, 22, 57, 80, 23]
 * [4, 13, 16, 22, 35, 82, 57, 80, 23]
 * [4, 13, 16, 22, 23, 82, 57, 80, 35]
 * [4, 13, 16, 22, 23, 35, 57, 80, 82]
 * [4, 13, 16, 22, 23, 35, 57, 80, 82]
 * [4, 13, 16, 22, 23, 35, 57, 80, 82]
 * [4, 13, 16, 22, 23, 35, 57, 80, 82]
 *
 * @author LiuYJ
 * @since 2018/8/17
 */
public class SelectSort extends Sort {

    @Override
    void sort(int[] arr) {
        System.out.println("================Select Sorting...================");
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            exchange(arr, i, min);
            System.out.println(Arrays.toString(arr));
        }
    }
}
