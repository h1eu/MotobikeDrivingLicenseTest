package com.example.mototest.Model;

public class Forum {
    private int idCmt;
    private int idTest;
    private int idUser;
    private String content;
    private int like;
    private int disLike;

    public Forum(int idCmt, int idTest, int idUser, String content, int like, int disLike) {
        this.idCmt = idCmt;
        this.idTest = idTest;
        this.idUser = idUser;
        this.content = content;
        this.like = like;
        this.disLike = disLike;

    }
}
