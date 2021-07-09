package com.example.mototest.Api;

import java.io.Serializable;

public class Status implements Serializable {
    private boolean status;

    public Status(boolean status) {
        this.status = status;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
