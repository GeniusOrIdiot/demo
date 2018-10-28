package com.example.demo.java_code.simulation;

/**
 * All copyright by Liuyajun.
 * <p>
 * Created by mdmor on 2018/10/25
 * </p>
 */
public class Bus implements Runnable {
    private BusStop busStop;
    // 0: moving 1: boarding
    private int state;

    public Bus(BusStop busStop) {
        this.busStop = busStop;
        this.state = 0;
    }

    public void move() {
        this.state = 0;
    }

    public void board() {
        synchronized (this.busStop) {
            if (this.busStop.isEmpty() || this.busStop.isBoarding()) {
                this.busStop = this.busStop.next;
                return;
            } else {
                this.state = 1;
                this.busStop.setBoard();
            }
        }
        boarding();
        this.busStop.boarded();
        this.move();
        this.busStop = this.busStop.next;
    }

    private void boarding() {
        while (!this.busStop.isEmpty()) {
            this.busStop.board();
            try {
                // TODO 乘客上车间隔
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Bus-" + Thread.currentThread().getName() + ": boarded passengers from BusStop-" + this.busStop);
    }

    @Override
    public void run() {
        while (true) {
            try {
                // TODO 公交车两站之间时间间隔
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            board();
        }
    }
}
