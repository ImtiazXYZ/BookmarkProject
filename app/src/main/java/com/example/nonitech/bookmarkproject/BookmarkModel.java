package com.example.nonitech.bookmarkproject;

import com.google.gson.annotations.SerializedName;

public class BookmarkModel {

    int id;
    //if I cnahge any name which isn't matching with database class
   // @SerializedName("name")
    String name;
    String age,description,image;

    public BookmarkModel(int id, String name, String age, String description, String image) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.description = description;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
