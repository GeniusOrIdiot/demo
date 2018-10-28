package com.example.demo.java_code.sort;

/**
 * @author LiuYJ
 * @since 2018/8/17
 */
public abstract class AbstractSort implements Sort {

    void exchange(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
