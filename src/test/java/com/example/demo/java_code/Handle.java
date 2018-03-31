package com.example.demo.java_code;

/**
 * Copyright (c) 2017-present, Demart Corporation.
 * All rights reserved.
 * <p>
 * Created by MDMORY on 2017/12/25.
 * </p>
 */
public class Handle {
    private String src = "nice";

    private StringBuffer str = new StringBuffer("good");

    private char[] ch = {'a', 'b', 'c'};

    public static void main(String args[]) {

        Handle ex = new Handle();

        System.out.println(ex.src.hashCode());

        ex.change(ex.src, ex.str, ex.ch);

        System.out.print(ex.str + " and ");

        System.out.println(ex.ch);

        System.out.println(ex.src + "----hash:" + ex.src.hashCode());

    }

    private void change(String src, StringBuffer str, char ch[]) {
        src = src.replace("n", "r");

        System.out.println(src.hashCode());

        str.append("a");

        ch[0] = 'g';

    }
}
