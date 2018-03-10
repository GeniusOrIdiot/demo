package com.example.demo.task;

import com.example.demo.service.ValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author LiuYJ
 * @since 2018/3/6
 */
@Component
public class RunTest {
    @Autowired
    private ValueService valueService;

//    @PostConstruct
    public void run() {
        Thread th_1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                valueService.addValue(1, 1);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread th_2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                valueService.subtractValue(1, 1);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        th_1.start();
        th_2.start();
    }

//    @PostConstruct
    public void _run() {
        Thread th_1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                valueService._addValue(1, 1);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread th_2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                valueService._subtractValue(1, 1);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        th_1.start();
        th_2.start();
    }
}
