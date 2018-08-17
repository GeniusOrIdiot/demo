package com.example.demo.java_code;

import java.util.Arrays;

/**
 * @author LiuYJ
 * @since 2018/8/15
 */
public class Solution {

    public static void main(String[] args) {
        int[][] rectangles = {{3, 0, 2, 2}, {2, 0, 2, 3}, {1, 0, 3, 1}};
        System.out.println(rectangleArea(rectangles));
        System.out.println(Arrays.toString(sort(rectangles)[0]));
    }

    private static int rectangleArea(int[][] rectangles) {
        rectangles = sort(rectangles);
        int area = (rectangles[0][2] - rectangles[0][0]) * (rectangles[0][3] - rectangles[0][1]);
        for (int i = 0; i < rectangles.length; i++) {

            for (int j = i + 1; j < rectangles.length; j++) {

            }
        }
        return 0;
    }

    private static int[][] sort(int[][] rectangles) {
        for (int i = 0; i < rectangles.length; i++) {
            int[] temp = rectangles[i];
            for (int j = 0; j <= i; j++) {
                if (temp[0] < rectangles[j][0]) {
                    rectangles[j] = temp;
                    temp = rectangles[j];
                }
            }
        }
        return rectangles;
    }
}
