package com.example.appfood.model;

public class BestForYou {
    String name;
    String text;
    Integer rating;
    String time;
    Integer imageUrl;



    public BestForYou(String name, String text, Integer rating, String time, int bestforyou1) {
        this.name = name;
        this.rating = rating;
        this.time = time;
        this.text = text;
        this.imageUrl = imageUrl;

    }

    public void setText(String text) {
        this.text = text;
    }



    public String getText() {
        return text;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }


    public Integer getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(Integer imageUrl) {
        this.imageUrl = imageUrl;
    }


}
