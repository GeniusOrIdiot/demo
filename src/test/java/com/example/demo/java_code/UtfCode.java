package com.example.demo.java_code;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author LiuYJ
 * @since 2018/2/22
 */
public class UtfCode {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.next();
        while (!str.equals("exit")) {
            try {
                byte[] binary = str.getBytes("utf-8");
                System.out.println(Arrays.toString(binary));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            str = scan.next();
        }
    }
}
