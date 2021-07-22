package com.example.mototest.Model;

import java.io.Serializable;
import java.util.ArrayList;

public class Post implements Serializable {
    ArrayList<ContentPost> Post,LuatGT,BienBao,MucXP;

    public ArrayList<ContentPost> getPost() {
        return Post;
    }
    public void setPost(ArrayList<ContentPost> post) {
        Post = post;
    }

    public ArrayList<ContentPost> getLuatGT() {
        return LuatGT;
    }

    public void setLuatGT(ArrayList<ContentPost> luatGT) {
        LuatGT = luatGT;
    }

    public ArrayList<ContentPost> getBienBao() {
        return BienBao;
    }

    public void setBienBao(ArrayList<ContentPost> bienBao) {
        BienBao = bienBao;
    }

    public ArrayList<ContentPost> getMucXP() {
        return MucXP;
    }

    public void setMucXP(ArrayList<ContentPost> mucXP) {
        MucXP = mucXP;
    }
}
