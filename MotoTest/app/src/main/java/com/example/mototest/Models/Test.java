package com.example.mototest.Models;

import java.io.Serializable;

public class Test implements Serializable {
    private String name;

    public Test(String name) {
        this.name = name;
    }

    public Test() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
