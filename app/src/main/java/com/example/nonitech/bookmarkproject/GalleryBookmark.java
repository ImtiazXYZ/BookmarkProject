package com.example.nonitech.bookmarkproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import static com.example.nonitech.bookmarkproject.APi.BASE_URL;

public class GalleryBookmark extends AppCompatActivity {
    String imageurl,name,age,description;
    final String imagelink=BASE_URL+"images/";
    ImageView galleryImage;
    TextView nameTv,ageTv, desTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery_bookmark);

        galleryImage=findViewById(R.id.galleryImage);
        nameTv=findViewById(R.id.gallerynameText);
        ageTv=findViewById(R.id.galleryageTwxt);
        desTv=findViewById(R.id.gallerydescription);


        imageurl=getIntent().getStringExtra("image");
        name=getIntent().getStringExtra("name");
        age=getIntent().getStringExtra("age");
        description=getIntent().getStringExtra("description");



        Glide.with(this).load(imagelink+imageurl).into(galleryImage);
        nameTv.setText(name);
        ageTv.setText(age);
        desTv.setText(description);


    }
}
