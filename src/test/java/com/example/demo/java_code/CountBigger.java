package com.example.demo.java_code;

public class CountBigger {
    public static void main(String[] args) {

        String src = "2?3?";
        System.out.println(src.indexOf("?"));

        int target = 2137;
        int result = countNum(src,target);
        System.out.println("result="+result);
    }

    static int countNum(String src, int target){
        for(int i=0;i<10;i++) {
            src = src.replaceFirst("\\?", i+"");
        }

        Integer parse = Integer.parseInt(src);
        return parse>target?parse-target:0;
    }
}
