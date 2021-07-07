package com.example.mototest.Model;

public class User {
    private int Iduser;
    private String Username;
    private String Password;
    private String Name;
    private String Permission;

    public int getIduser() {
        return Iduser;
    }

    public void setIduser(int iduser) {
        Iduser = iduser;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
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

    public String getPermission() {
        return Permission;
    }

    public void setPermission(String permission) {
        Permission = permission;
    }

    public User(){
        this.Iduser = Iduser;
        this.Username = Username;
        this.Password = Password;
        this.Name = Name;
    }

    public User(int Iduser , String Username,String Password ,String Name,String Permission){
        this.Iduser = Iduser;
        this.Username = Username;
        this.Password = Password;
        this.Name = Name;
        this.Permission=Permission;
    }

}
