package com.example.mototest.Model;

public class Ranking {
    private int idUser;
    private int idTest;
    private String userName;
    private int scores;
    public Ranking(int idUser,int idTest,String userName,int scores){
        this.idUser = idUser;
        this.idTest = idTest;
        this.userName = userName;
        this.scores = scores;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdTest() {
        return idTest;
    }

    public void setIdTest(int idTest) {
        this.idTest = idTest;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getScores() {
        return scores;
    }

    public void setScores(int scores) {
        this.scores = scores;
    }
}
