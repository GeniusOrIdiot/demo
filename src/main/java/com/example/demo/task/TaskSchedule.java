package com.example.demo.task;

import com.example.demo.utils.TaskQueue;

import java.util.ArrayDeque;
import java.util.List;

/**
 * @author LiuYJ
 * @since 2018/2/10
 */
public class TaskSchedule {
    private TaskQueue<List<Task>> taskQueue;
    private TaskThread taskThread;



}

class TaskThread implements Runnable {
    private TaskQueue<List<Task>> taskQueue;


    @Override
    public void run() {

    }
}
