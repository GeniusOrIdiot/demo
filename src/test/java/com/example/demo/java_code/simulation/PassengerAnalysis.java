package com.example.demo.java_code.simulation;

import java.util.HashSet;
import java.util.Set;

/**
 * All copyright by Liuyajun.
 * <p>
 * Created by mdmor on 2018/10/25
 * </p>
 */
public class PassengerAnalysis implements Runnable {
    private BusStop busStop;

    public PassengerAnalysis(BusStop busStop) {
        this.busStop = busStop;
    }

    @Override
    public void run() {
        Set<Integer> sizeData = new HashSet<>();
        // TODO 数据分析时间区间 此处为0~60s
        for (int i = 0; i < 60; i ++) {
            sizeData.add(this.busStop.size());
            try {
                // TODO 此处为等待乘客自增间隔，两处需同时变更
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        int max = sizeData.stream().max(Integer::compareTo).orElse(0);
        int min = sizeData.stream().min(Integer::compareTo).orElse(0);
        int sum = 0;
        for (Integer i : sizeData) {
            sum += i;
        }
        int average = sum / sizeData.size();
        System.out.println("BusStop-" + this.busStop + " analysis data:");
        System.out.println("Max size: " + max);
        System.out.println("Min size: " + min);
        System.out.println("Average size:" + average);
    }
}
