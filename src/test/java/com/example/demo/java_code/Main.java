package com.example.demo.java_code;

import java.lang.Math;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String chs=new String(generate());
        System.out.println(chs);
        Arrays.toString(generate());

        System.out.println("请输入验证码：");
        Scanner scan=new Scanner(System.in);
        String ans=scan.next().toUpperCase();
        check(ans,chs.toUpperCase());

    }
    public static char[] generate(){
        char []chs=new char[5];
        char []letters=new char[]{ 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
                'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
                'W', 'X', 'Y', 'Z','a','b','c','b','d','e','f','g','h','i','j','k','l','m','n','o','p','q',
                'r','s','t','u','v','w','x','y','z'};
        boolean []flags=new boolean[letters.length];
        for(int i=0;i<chs.length;i++){
            int index=0;
            do{
                index=(int)(Math.random()*52);
            }while(flags[index]);
            chs[i]=letters[index];
            flags[index]=true;

        }
        return chs;
    }
    public static void check(String ans,String chs){
        if(chs.equals(ans)){
            System.out.println("验证成功");
        }else{
            System.out.println("请重新输入");
        }
    }
}
