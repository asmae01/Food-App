package com.example.appfood.model;

public class Recettes {
    private String name;
    private  String descrition;
    private String type;
    private Integer image;
    private Boolean fav = true;

    public Recettes(String name, String descrition, String type, Integer image) {
        this.name = name;
        this.descrition = descrition;
        this.type = type;
        this.image = image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescrition(String descrition) {
        this.descrition = descrition;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setImage(Integer image) {
        this.image = image;
    }

    public Boolean getFav() {
        return fav;
    }

    public void setFav(Boolean fav) {
        this.fav = fav;
    }

    @Override
    public String toString() {
        return "Recettes{" +
                "name='" + name + '\'' +
                ", descrition='" + descrition + '\'' +
                ", type='" + type + '\'' +
                ", image=" + image +
                '}';
    }

    public String getName() {
        return name;
    }

    public String getDescrition() {
        return descrition;
    }

    public String getType() {
        return type;
    }

    public Integer getImage() {
        return image;
    }

    public Recettes(String name, String descrition, String type) {
        this.name = name;
        this.descrition = descrition;
        this.type = type;
    }
}
