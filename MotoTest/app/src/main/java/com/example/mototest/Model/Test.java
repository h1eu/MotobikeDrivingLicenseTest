package com.example.mototest.Model;

public class Test {
    private int idTest;
    private String listQuestion;
    private long time ;
    public Test(int idTest , String listQuestion , long time){
        this.idTest = idTest;
        this.listQuestion = listQuestion;
        this.time = time;
    }

    public int getIdTest() {
        return idTest;
    }

    public void setIdTest(int idTest) {
        this.idTest = idTest;
    }

    public String getListQuestion() {
        return listQuestion;
    }

    public void setListQuestion(String listQuestion) {
        this.listQuestion = listQuestion;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
