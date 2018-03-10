package com.example.demo.java_code;

/**
 * Copyright (c) 2017-present, Demart Corporation.
 * All rights reserved.
 * <p>
 * Created by MDMORY on 2017/11/17.
 * </p>
 */
public class ListTest {
    public static void main(String[] args) {
        /*List<Cell> list = new ArrayList<>();
        Cell cell = new Cell("a", 3);
        list.add(cell);
        System.out.println(list.get(0));
        Cell cell1 = list.get(0);
        cell1.setName("b");
        System.out.println(list.get(0));*/

        Cell cell = new Cell();
        try {
            Cell cell1 = cell.clone();
            System.out.println(cell1==cell);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
