package com.example.mototest.Model;

public class Question {

        private int idQuestion;
        private String kindofquestion;
        private String Content;
        private String image;
        private String DA1;
        private String DA2;
        private String DA3;
        private String DA4;



    private String answer;
        public Question(int idQuestion , String kindofquestion, String Content ,String image ,String answer){
            this.idQuestion = idQuestion;
            this.kindofquestion = kindofquestion;
            this.Content = Content;
            this.image = image;
            this.answer = answer;

        }

        public int getIdQuestion() {
            return idQuestion;
        }

        public void setIdQuestion(int idQuestion) {
            this.idQuestion = idQuestion;
        }

        public String getKindofquestion() {
            return kindofquestion;
        }

        public void setKindofquestion(String kindofquestion) {
            this.kindofquestion = kindofquestion;
        }

        public String getContent() {
            return Content;
        }

        public void setContent(String content) {
            Content = content;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getAnswer() {
            return answer;
        }

        public void setAnswer(String answer) {
            this.answer = answer;
        }

        public String getDA1() {
            return DA1;
        }

        public void setDA1(String DA1) {
            this.DA1 = DA1;
        }

        public String getDA2() {
            return DA2;
        }

        public void setDA2(String DA2) {
            this.DA2 = DA2;
        }

        public String getDA3() {
            return DA3;
        }

        public void setDA3(String DA3) {
            this.DA3 = DA3;
        }

        public String getDA4() {
            return DA4;
        }

        public void setDA4(String DA4) {
            this.DA4 = DA4;
        }

}
