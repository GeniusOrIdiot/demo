package com.example.demo.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiuYJ
 * @since 2018/2/10
 */
public class TaskQueue<E> {
    private Object[] taskList;
    private static final int DEFAULT_INITIAL_CAPACITY = 3600;

    private int head = 0;
    private int tail = 0;

    public TaskQueue() {
        taskList = new Object[DEFAULT_INITIAL_CAPACITY];
        for (int i = 0; i < taskList.length; i++) {
            taskList[i] = new ArrayList<E>();
        }
    }

    public TaskQueue(int size) {
        taskList = new Object[size];
        for (int i = 0; i < taskList.length; i++) {
            taskList[i] = new ArrayList<E>();
        }
    }

    public void addTask(E e, int interval) {
        if (e == null)
            throw new NullPointerException();
        tail = (tail + interval) % taskList.length;
        @SuppressWarnings("unchecked")
        List<E> list = (List<E>) taskList[tail];
        list.add(e);
        taskList[tail] = list;
    }

    public List<E> pollTasks() {
        @SuppressWarnings("unchecked")
        List<E> list = (List<E>) taskList[head];
        list.clear();
        taskList[head] = list;
        return list;
    }
}
