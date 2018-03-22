package com.example.demo.design_pattern.singleton;

/**
 * 静态内部类创建单例
 *
 * @author LiuYJ
 * @since 18/03/2018
 */
public class StaticInnerSingleton {

    private static class SingletonHolder {
        private static StaticInnerSingleton instance = new StaticInnerSingleton();
    }

    private StaticInnerSingleton() {
    }

    public static StaticInnerSingleton newInstance() {
        return SingletonHolder.instance;
    }
}
