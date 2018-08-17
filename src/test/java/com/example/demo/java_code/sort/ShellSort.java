package com.example.demo.java_code.sort;

import java.util.Arrays;

/**
 * 希尔排序：
 *   高级而神秘的插入算法。
 *
 * @author LiuYJ
 * @since 2018/8/17
 */
public class ShellSort extends Sort {

    @Override
    void sort(int[] arr) {
        System.out.println("================Shell Sorting...================");
        int n = arr.length;
        int h = 1;
        while (h < n / 3) {
            h = h * 3 + 1;
        }
        while (h >= 1) {
            for (int i = h; i < n; i++) {
                for (int j = i; j >= h; j -= h) {
                    if (arr[j] < arr[j - h]) {
                        exchange(arr, j, j - h);
                    }
                }
            }
            h = h / 3;
            System.out.println(Arrays.toString(arr));
        }
    }
}
