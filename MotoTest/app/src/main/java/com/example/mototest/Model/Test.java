package com.example.mototest.Model;

import java.io.Serializable;

public class Test implements Serializable {
    public class Test {
        private int Idtest;
        private int Listquestion;
        private long Time;

        public Test(int Idtest, int ListQuestion, long Time) {
            this.Idtest = Idtest;
            this.Listquestion = ListQuestion;
            this.Time = Time;
        }

        public int getIdtest() {
            return Idtest;
        }

        public void setIdtest(int idtest) {
            Idtest = idtest;
        }

        public int getListquestion() {
            return Listquestion;
        }

        public void setListquestion(int listquestion) {
            Listquestion = listquestion;
        }

        public long getTime() {
            return Time;
        }

        public void setTime(long time) {
            Time = time;
        }
    }
}
