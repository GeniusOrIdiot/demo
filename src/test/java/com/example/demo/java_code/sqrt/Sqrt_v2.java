package com.example.demo.java_code.sqrt;

import java.util.Scanner;

/**
 * @author LiuYJ
 * @since 01/02/2018
 */
public class Sqrt_v2 {

    public static void main(String[] args) {
        System.out.println("Input a num (>=0):");
        Scanner scanner = new Scanner(System.in);
        double num = scanner.nextDouble();

//        System.out.println("---------   数位迭代   ---------");
//        System.out.println("Result:" + Math.sqrt(num, 13));
        System.out.println("---------    二分法    ---------");
//        System.out.println("Result:" + Math.MidCut.sqrt(num, 0.00000000001));
        System.out.println("---------   牛顿迭代   ---------");
//        System.out.println("Result:" + NewtonSqrt.sqrt(num, 12345 / 2));
        System.out.println("---------   牛顿迭代   ---------");
//        System.out.println("Result:" + NewtonSqrt.sqrt(num, 100));
        System.out.println("--------- Java Math库 ---------");
        long begin = System.nanoTime();
        double result = java.lang.Math.sqrt(num);
        long end = System.nanoTime();
        System.out.println("耗时：" + (end - begin) + "ns");
        System.out.println("Result:" + result);
    }
}
