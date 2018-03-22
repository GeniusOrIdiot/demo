package com.example.demo.design_pattern.singleton;

/**
 * 懒汉模式
 *
 * @author LiuYJ
 * @since 18/03/2018
 */
public class LazyMan {
    private static LazyMan instance = null;

    private LazyMan() {
    }

    public static LazyMan getInstance() {
        if (instance == null) {
            instance = new LazyMan();
        }
        return instance;
    }
}
