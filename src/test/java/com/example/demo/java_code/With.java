package com.example.demo.java_code;

/**
 * @author LiuYJ
 * @since 01/02/2018
 */
public class With {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(i & 7);
        }

        Integer a = new Integer(1);
        Integer b = new Integer(1);
        System.out.println(a == b);
    }
}
