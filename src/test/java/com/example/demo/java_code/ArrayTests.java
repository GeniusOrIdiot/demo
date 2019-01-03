package com.example.demo.java_code;

import com.example.demo.java_code.obj.Cell;
import com.example.demo.java_code.obj.Doll;
import com.example.demo.java_code.obj.Evil;

public class ArrayTests<T extends Comparable> {

    public static void main(String[] args) {
        Cell[] dolls = new Evil[1];
        dolls[0] = new Doll();
        dolls[0].setName("doll0");
        test1(dolls);
    }

    private static void test1(Cell[] cells) {
        System.out.println(cells[0].getName());
    }

    public static <T extends Comparable<? super T>> T testMax(T[] arr) {
        int maxIndex = 0;
        for (T t : arr) {
            if (t.compareTo(arr[maxIndex]) > 0) {
                arr[maxIndex] = t;
            }
        }

        return arr[maxIndex];
    }
}
