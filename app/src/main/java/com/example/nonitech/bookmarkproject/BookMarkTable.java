package com.example.nonitech.bookmarkproject;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "bookmark_table")
public class BookMarkTable {

    @PrimaryKey(autoGenerate = true)
    public  int id;
    @ColumnInfo(name = "name")
    String name;
    @ColumnInfo(name = "age")
    String age;
    @ColumnInfo(name = "description")
    String description;

   /* @ColumnInfo(typeAffinity = ColumnInfo.BLOB)
    byte[] image;*/
   @ColumnInfo(name = "image_url")
    String image_url;

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

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }
}
