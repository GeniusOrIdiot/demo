package com.example.demo.java_code;

import com.example.demo.java_code.obj.Cell;
import com.google.gson.GsonBuilder;

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
        System.out.println(new GsonBuilder().create().toJson(cell));

        for(Cell c : list){
            System.out.println(c);
        }
    }
}
