package com.example.demo.java_code;

import java.math.BigDecimal;

public class DoubleTest {

    public static void main(String[] args) {
        doubleTest();
        decimalTest();
        stringTest();
    }

    static void doubleTest() {
        double conf = 0.09;
        BigDecimal sum = new BigDecimal(100);
        BigDecimal re = sum.multiply(new BigDecimal(conf));
        System.out.println("DoubleResult = " + re);
    }

    static void decimalTest() {
        BigDecimal conf = new BigDecimal("0.6");
        BigDecimal sum = new BigDecimal(100);
        BigDecimal re = sum.multiply(conf);
        System.out.println("StringParseResult = " + re);
    }

    static void stringTest() {
        BigDecimal conf = new BigDecimal(String.valueOf(1-0.4));
        BigDecimal sum = new BigDecimal(100);
        BigDecimal re = sum.multiply(conf);
        System.out.println("BigDecimalResult = " + re);
    }
}
