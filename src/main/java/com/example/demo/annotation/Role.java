package com.example.demo.annotation;

/**
 * @author LiuYJ
 * @since 04/05/2018
 */
class Role {
    private String name;
    private String work;

    Role(String name) {
        this.name = name;
    }

    public void setWork(String work) {
        this.work = work;
    }

    @Override
    public String toString() {
        return "Role{" +
                "name='" + name + '\'' +
                ", work='" + work + '\'' +
                '}';
    }
}
