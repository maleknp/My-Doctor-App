package com.example.mydoctor;

public class Model {
    private int id;
    private String image;
    private String title;
//    private String desc;

    public Model(String image, String title, int id) {
        this.id= id;
        this.image = image;
        this.title = title;
//        this.desc = desc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

//    public String getDesc() {
//        return desc;
//    }
//
//    public void setDesc(String desc) {
//        this.desc = desc;
//    }
}
