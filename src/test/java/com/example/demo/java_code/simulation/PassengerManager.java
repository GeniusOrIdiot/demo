package com.example.demo.java_code.simulation;

/**
 * All copyright by Liuyajun.
 * <p>
 * Created by mdmor on 2018/10/25
 * </p>
 */
public class PassengerManager implements Runnable {
    private BusStop first;
    private BusStop last;

    public void initialBusStops(int size) {
        this.first = new BusStop();
        this.last = this.first;
        for (; size > 1; size--) {
            addBusStop();
        }
        this.last.next = this.first;
        System.out.println("BusStops initialized!");
    }

    public BusStop first() {
        return this.first;
    }

    public BusStop last() {
        return this.last;
    }

    private void addBusStop() {
        BusStop l = this.last;
        l.next = new BusStop();
        this.last = l.next;
    }

    public void run() {
        while (true) {
            BusStop node = first;
            while (node != this.last) {
                node.waitAdd();
                System.out.println("BusStop has " + node.size() + " passengers.");
                node = node.next;
            }
            node.waitAdd();
            System.out.println("BusStop has " + node.size() + " passengers.");
            System.out.println("Passenger updated!");
            try {
                // TODO 车站等待乘客自增间隔
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
