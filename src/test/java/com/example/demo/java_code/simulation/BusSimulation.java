package com.example.demo.java_code.simulation;

/**
 * All copyright by Liuyajun.
 * <p>
 * Created by mdmor on 2018/10/25
 * </p>
 */
public class BusSimulation {
    public static void main(String[] args) {
        PassengerManager pm = new PassengerManager();
        // TODO 配置车站数
        pm.initialBusStops(3);
        Thread pmThread = new Thread(pm);
        // TODO 配置车辆数，即线程数量，一个线程代表一辆车
        Thread bus_1 = new Thread(new Bus(pm.first()));
        Thread bus_2 = new Thread(new Bus(pm.first()));
//        Thread bus_3 = new Thread(new Bus(pm.first()));
//        Thread bus_4 = new Thread(new Bus(pm.first()));
//        Thread bus_5 = new Thread(new Bus(pm.first()));
        pmThread.start();
        bus_1.start();
        bus_2.start();
//        bus_3.start();
//        bus_4.start();
//        bus_5.start();
        // TODO 乘客分析类构造参数就是你要分析的那个车站，此处以第一个车站为例，全部车站数据可以通过遍历获取
        BusStop node = pm.first();
        while (node != pm.last()) {
            Thread analysis = new Thread(new PassengerAnalysis(node));
            analysis.start();
            node = node.next;
        }
        Thread analysis = new Thread(new PassengerAnalysis(node));
        analysis.start();
    }
}
