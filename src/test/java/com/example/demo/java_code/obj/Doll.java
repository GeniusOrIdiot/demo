package com.example.demo.java_code.obj;

public class Doll extends Cell {
    private String name;

    @Override
    public String toString() {
        return "Doll{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
