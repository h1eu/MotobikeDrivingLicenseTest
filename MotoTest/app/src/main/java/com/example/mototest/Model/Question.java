package com.example.mototest.Model;

public class Question {

        private int idQuestion;
        private String kindofquestion;
        private String Content;
        private String image;
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


}
