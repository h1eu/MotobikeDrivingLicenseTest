package com.example.mototest.Api;

import com.example.mototest.Model.Comment;


import java.io.Serializable;
import java.util.ArrayList;

public class AllCmt implements Serializable {
    private ArrayList<Comment> allCmt;

    public AllCmt(ArrayList<Comment> allCmt) {
        this.allCmt = allCmt;
    }

    public ArrayList<Comment> getAllCmt() {
        return allCmt;
    }

    public void setAllCmt(ArrayList<Comment> allCmt) {
        this.allCmt = allCmt;
    }
}
