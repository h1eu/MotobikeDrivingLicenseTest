package com.example.mototest.Model;

public class Post {
    private int idPost;
    private String title;
    private String content;
    private String image;
    public Post(int idPost ,String title  ,String content ,String image){
        this.idPost = idPost;
        this.title = title;
        this.content = content;
        this.image = image;

    }

    public int getIdPost() {
        return idPost;
    }

    public void setIdPost(int idPost) {
        this.idPost = idPost;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
