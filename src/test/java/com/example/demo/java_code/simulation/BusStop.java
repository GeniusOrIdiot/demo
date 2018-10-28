package com.example.demo.java_code.simulation;

/**
 * All copyright by Liuyajun.
 * <p>
 * Created by mdmor on 2018/10/25
 * </p>
 */
public class BusStop {
    // waiting persons
    private int size = 0;
    private boolean isBoarding = false;

    public BusStop next;

    public void waitAdd() {
        this.size++;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void boarded() {
        this.isBoarding = false;
    }

    public boolean isBoarding() {
        return this.isBoarding;
    }

    public void setBoard() {
        this.isBoarding = true;
    }

    public void board() {
        this.size--;
    }
}
