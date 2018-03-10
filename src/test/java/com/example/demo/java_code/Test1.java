package com.example.demo.java_code;

import java.util.ArrayList;
import java.util.List;

public class Test1 {
    public static void main(String[] args){

        List<Cell> list = new ArrayList<>();
        Cell cell = new Cell();

        cell.setName("a");
        list.add(cell);
        cell.setName("b");
        list.add(cell);
        cell.setName("c");
        list.add(cell);
        System.out.println(list.size());

        for(Cell c : list){
            System.out.println(c);
        }
    }
}
