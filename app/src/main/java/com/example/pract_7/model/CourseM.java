package com.example.pract_7.model;

public class CourseM {

    int id;
    String img, title, date, level, color;

    public CourseM(int id, String img) {
        this.id = id;
        this.img = img;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

}
