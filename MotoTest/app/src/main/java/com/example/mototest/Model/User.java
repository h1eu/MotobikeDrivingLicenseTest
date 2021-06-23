package com.example.mototest.Model;

public class User {
    private int idUser;
    private String userName;
    private String Password;
    private String Name;

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public User(){
        this.idUser = idUser;
        this.userName = userName;
        this.Password = Password;
        this.Name = Name;
    }

    public User(int idUser , String userName,String Password ,String Name){
        this.idUser = idUser;
        this.userName = userName;
        this.Password = Password;
        this.Name = Name;
    }

}
