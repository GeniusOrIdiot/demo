package com.example.demo.java_code.sort;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * All copyright by Liuyajun.
 * <p>
 * Created by mdmor on 2018/10/28
 * </p>
 */
public class SortProxy implements InvocationHandler {
    private Object target;

    public SortProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long begin = System.nanoTime();
        Object result = method.invoke(target, args);
        long end = System.nanoTime();
        System.out.println("Using time: " + (end - begin) + "ns");
        return result;
    }
}
