package com.example.demo.java_code;

import java.math.BigDecimal;

/**
 * @author LiuYJ
 * @since 08/05/2018
 */
public class BirthdayParadox {
    public static void main(String[] args) {
        BigDecimal result = new BigDecimal("1");
        for (int i = 364; i > 307; i--) {
            result = result.multiply(new BigDecimal(i).divide(new BigDecimal(365), 4, BigDecimal.ROUND_DOWN));
        }
        System.out.println(result);
    }
}
