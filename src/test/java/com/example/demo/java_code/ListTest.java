package com.example.demo.java_code;

import com.example.demo.java_code.obj.Cell;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Copyright (c) 2017-present, Demart Corporation.
 * All rights reserved.
 * <p>
 * Created by MDMORY on 2017/11/17.
 * </p>
 */
public class ListTest {
    public static void main(String[] args) {
        List<Cell> list = new ArrayList<>();
        Cell cell = new Cell("a", 3);
        list.add(cell);
        System.out.println(list.get(0));
        Cell cell1 = list.get(0);
        cell1.setName("b");
        System.out.println(list.get(0));
        list.add(new Cell("c", 12));
        System.out.println(list);
        Iterator<Cell> it = list.iterator();
        while (it.hasNext()) {
            it.next();
            it.remove();
        }
        System.out.println(list);
    }
}
