package com.example.demo.java_code;

/**
 * Copyright (c) 2017-present, Demart Corporation.
 * All rights reserved.
 * <p>
 * Created by MDMORY on 2017/12/25.
 * </p>
 */
public class Handle {
    StringBuffer str = new StringBuffer("good");

    char[] ch = { 'a', 'b', 'c' };

    public static void main(String args[]) {

        Handle ex = new Handle();

        ex.change(ex.str, ex.ch);

        System.out.print(ex.str + " and ");

        System.out.print(ex.ch);

    }

    public void change(StringBuffer str, char ch[]) {

        str.append("a");

        ch[0] = 'g';

    }
}
