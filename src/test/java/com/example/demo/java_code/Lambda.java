package com.example.demo.java_code;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiuYJ
 * @since 2018/2/28
 */
public class Lambda {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
        list.stream().reduce((a, b) -> a + b).get();
    }
}
