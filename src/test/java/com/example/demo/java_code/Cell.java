package com.example.demo.java_code;

import com.google.gson.annotations.SerializedName;

public class Cell {
    @SerializedName("mmmm")
    private String name;
    @SerializedName("aaaaa")
    private int age;

    Cell() {
    }

    public Cell(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Cell{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public Cell clone() throws CloneNotSupportedException {
        return (Cell) super.clone();
    }
}
