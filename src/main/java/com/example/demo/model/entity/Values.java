package com.example.demo.model.entity;

import javax.persistence.*;

/**
 * @author LiuYJ
 * @since 2018/3/6
 */
@Entity
@Table(name = "tbl_values")
public class Values {
    @Id
    @GeneratedValue
    private int id;

    @Column(name = "value")
    private int value;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
