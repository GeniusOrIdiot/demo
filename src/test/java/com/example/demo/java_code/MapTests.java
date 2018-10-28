package com.example.demo.java_code;

import java.util.HashMap;
import java.util.Map;

/**
 * All copyright by Liuyajun.
 * <p>
 * Created by mdmor on 2018/10/15
 * </p>
 */
public class MapTests {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("a", "aa");
        map.put("b", "bb");
        map.put("c", "cc");
        System.out.println(map);
        for (Object o : map.keySet()) {
            System.out.println(o);
        }
    }
}
