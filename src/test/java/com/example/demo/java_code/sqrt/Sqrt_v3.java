package com.example.demo.java_code.sqrt;

import java.util.Scanner;

/**
 * 二分法
 *
 * @author LiuYJ
 * @since 02/02/2018
 */
public class Sqrt_v3 {
    private static double a;
    private static double b;
    private static Double result;

    public static void main(String[] args) {
        System.out.println("Input a num (>=0):");
        Scanner scanner = new Scanner(System.in);
        double num = scanner.nextDouble();
        if (num >= 1) {
            a = 1;
            b = num;
        } else {
            a = num;
            b = 1;
        }
        do {
            midOne(num);
        } while (result == null);
        System.out.println("Result:" + result);
    }

    private static void midOne(double num) {
        double re = a + (b - a) / 2;
        double out = re * re - num;

        double miss = 0.0000001;
        if (out >= 0) {
            b = re;
            if (out <= miss) {
                result = re;
            }
        } else {
            a = re;
            if (out >= -1 * miss) {
                result = re;
            }
        }
    }
}
