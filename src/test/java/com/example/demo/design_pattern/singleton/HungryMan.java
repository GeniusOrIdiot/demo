package com.example.demo.design_pattern.singleton;

/**
 * 饿汉模式
 *
 * @author LiuYJ
 * @since 18/03/2018
 */
public class HungryMan {
    private static HungryMan instance = new HungryMan();

    private HungryMan() {
    }

    public static HungryMan getInstance() {
        return instance;
    }
}
