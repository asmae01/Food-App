package com.example.appfood.model;

public class Users {
    private int imageProfile;
    private  String username,userDesc;

    public Users(int imageProfile, String username, String userDesc) {
        this.imageProfile = imageProfile;
        this.username = username;
        this.userDesc = userDesc;
    }

    public int getImageProfile() {
        return imageProfile;
    }

    public void setImageProfile(int imageProfile) {
        this.imageProfile = imageProfile;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserDesc() {
        return userDesc;
    }

    public void setUserDesc(String userDesc) {
        this.userDesc = userDesc;
    }
}
