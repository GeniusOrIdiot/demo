package com.example.demo.design_pattern.singleton;

/**
 * 懒汉模式：
 * 双重校验锁，提高性能
 * 当instance不为null(常规情况都不是null)时，可以不进入锁状态等待
 *
 * @author LiuYJ
 * @since 18/03/2018
 */
public class DoubleLockLazyMan {
    private static DoubleLockLazyMan instance = null;

    /**
     * JVM有指令重排优化的过程：
     * 所谓指令重排优化是指在不改变原语义的情况下，通过调整指令的执行顺序让程序运行的更快。
     *
     * 就是说：一个实例获得其地址和在堆中初始化该对象的顺序并不是确定的。
     * 如果一个线程在创建单例的时候，这个instance刚刚获得地址值，堆中的对象还未初始化完成，
     * 而这时另一个线程也调用了getInstance()方法，就会获得一个没有实例对象，只有地址的instance，就会报错。
     *
     * @see volatile 关键字禁止指令重排，解决了这个问题
     * @since jdk1.5
     *
     */
    private static volatile DoubleLockLazyMan instance_1 = null;

    private DoubleLockLazyMan() {
    }

    public static DoubleLockLazyMan getInstance() {
        if (instance == null) {
            synchronized (DoubleLockLazyMan.class) {
                if (instance == null) {
                    instance = new DoubleLockLazyMan();
                }
            }
        }
        return instance;
    }
}
