package com.example.nonitech.bookmarkproject;

import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import static com.example.nonitech.bookmarkproject.APi.BASE_URL;

public class Favourite extends AppCompatActivity {
    ImageView imageView;
    TextView name,age,description;
    String imageUrl,showname,showage,showdescription;
    String uurl= BASE_URL+"images/";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite);
        imageView=findViewById(R.id.favimg);
        name=findViewById(R.id.fsvNme);
        age=findViewById(R.id.favage);
        description=findViewById(R.id.favdes);
        DatabaseBookmark databaseBookmark=Room.databaseBuilder(Favourite.this,DatabaseBookmark.class,"bookmark_data").allowMainThreadQueries().build();
        List<BookMarkTable> bookMarkTables=databaseBookmark.bookmarkInterfaceDAO().getAllData();
        for(BookMarkTable bookMarkTable : bookMarkTables){
            imageUrl=bookMarkTable.getImage_url();
            showname=bookMarkTable.getName();
            showage=bookMarkTable.getAge();
            showdescription=bookMarkTable.getDescription();
            }

        Glide.with(this).load(uurl+imageUrl).into(imageView);
            name.setText(showname);
            age.setText(showage);
            description.setText(showdescription);
    }
}
