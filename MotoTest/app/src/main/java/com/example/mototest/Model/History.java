package com.example.mototest.Model;

public class History {
    private int idTest;
    private int idUser;
    private int scores;
    private long time;
    public History(int idUser,int idTest,int scores, long time){
        this.idUser = idUser;
        this.idTest = idTest;
        this.scores = scores;
        this.time = time;
    }

    public int getIdTest() {
        return idTest;
    }

    public void setIdTest(int idTest) {
        this.idTest = idTest;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getScores() {
        return scores;
    }

    public void setScores(int scores) {
        this.scores = scores;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
