package com.example.demo.java_code;

/**
 * Copyright (c) 2017-present, Demart Corporation.
 * All rights reserved.
 * <p>
 * Created by MDMORY on 2017/12/25.
 * </p>
 */
public class Hello {
    private Hello() {
        System.out.println("Hello");
    }

    {
        System.out.println("Hello~");
    }

    static {
        System.out.println("Hello...");
    }

    public static void main(String[] args) {
        new Hello();
        Hello a = new Hello();
        Hello b;
        b = new Hello();
        System.out.println(a);
        System.out.println(b);
    }
}
