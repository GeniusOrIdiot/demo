package com.example.demo.java_code.sort;

import java.lang.reflect.Proxy;

/**
 * 排序算法统一测试
 *
 * @author LiuYJ
 * @since 2018/8/17
 */
public class SortTests {
    public static void main(String[] args) {
        int[] arr = {22, 13, 57, 82, 35, 4, 16, 80, 23, 78, 98, 37, 84, 17, 126, 89, 19};
        Sort bubbleSort = (Sort) Proxy.newProxyInstance(Sort.class.getClassLoader(),
                new Class[]{Sort.class},
                new SortProxy(new BubbleSort()));

        Sort selectSort = (Sort) Proxy.newProxyInstance(Sort.class.getClassLoader(),
                new Class[]{Sort.class},
                new SortProxy(new SelectSort()));

        Sort insertSort = (Sort) Proxy.newProxyInstance(Sort.class.getClassLoader(),
                new Class[]{Sort.class},
                new SortProxy(new InsertSort()));

        Sort shellSort = (Sort) Proxy.newProxyInstance(Sort.class.getClassLoader(),
                new Class[]{Sort.class},
                new SortProxy(new ShellSort()));

        bubbleSort.sort(arr);
        selectSort.sort(arr);
        insertSort.sort(arr);
        shellSort.sort(arr);
    }
}
