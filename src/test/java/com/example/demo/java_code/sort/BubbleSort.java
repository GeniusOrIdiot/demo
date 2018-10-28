package com.example.demo.java_code.sort;

/**
 * @author LiuYJ
 * @since 2018/8/17
 */
public class BubbleSort extends AbstractSort {

    @Override
    public void sort(int[] arr) {
        System.out.println("================Bubble Sorting...================");
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    exchange(arr, arr[i], arr[j]);
                }
            }
        }
    }
}
