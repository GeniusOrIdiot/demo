package com.example.demo.design_pattern.singleton;

/**
 * 懒汉模式：
 * 在线程并发的情况下可能会创建多个实例
 *
 * @author LiuYJ
 * @since 18/03/2018
 */
public class SyncLazyMan {
    private static SyncLazyMan instance = null;

    private SyncLazyMan() {
    }

    public static synchronized SyncLazyMan getInstance() {
        if (instance == null) {
            instance = new SyncLazyMan();
        }
        return instance;
    }
}
