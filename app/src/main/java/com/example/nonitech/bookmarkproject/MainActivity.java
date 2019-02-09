package com.example.nonitech.bookmarkproject;

import android.content.ClipData;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> mImageNames = new ArrayList<>();
    private ArrayList<String> mImages = new ArrayList<>();
    private ArrayList<String> mAge = new ArrayList<>();
    private ArrayList<String> mDescription = new ArrayList<>();

    Toolbar toolbar;
    TextView nametext;
    List<BookmarkModel> bookmarkModelList;
    RecyclerView recyclerViewl;
    BookMarkAdapter bookMarkAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nametext=findViewById(R.id.tvName);
        bookMarkAdapter=new BookMarkAdapter(getApplicationContext(),bookmarkModelList);



        recyclerViewl=findViewById(R.id.recyclebookmarList);
        recyclerViewl.setLayoutManager(new LinearLayoutManager(this));




        Retrofit retrofit=new Retrofit.Builder().baseUrl(APi.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        APi api= retrofit.create(APi.class);
        Call<List<BookmarkModel>> call= api.getBookmarData();
        call.enqueue(new Callback<List<BookmarkModel>>() {
            @Override
            public void onResponse(Call<List<BookmarkModel>> call, Response<List<BookmarkModel>> response) {
                bookmarkModelList=response.body();
                for (BookmarkModel bookmarkModel : bookmarkModelList ){
                    /*Log.d("name",bookmarkModel.getName());
                    Log.d("age",bookmarkModel.getAge());
                    Log.d("description",bookmarkModel.getDescription());
                    Log.d("Image",bookmarkModel.getImage());*/
                    /*bookMarkAdapter.setBookMarkList(bookmarkModelList);*/
                    mImages.add(bookmarkModel.getImage());
                    mImageNames.add(bookmarkModel.getName());
                    mAge.add(bookmarkModel.getAge());
                    mDescription.add(bookmarkModel.getDescription());
                   // bookMarkAdapter.setBookMarkList(bookmarkModelList);
                }
                bookMarkAdapter=new BookMarkAdapter(getApplicationContext(),mImages,mImageNames,mAge,mDescription);

                recyclerViewl.setAdapter(bookMarkAdapter);



            }

            @Override
            public void onFailure(Call<List<BookmarkModel>> call, Throwable t) {

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);


        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_favorite:

                Intent intent= new Intent(this,Favourite.class);
                startActivity(intent);

                Toast.makeText(this, "Clicked me", Toast.LENGTH_SHORT).show();

        }
        return super.onOptionsItemSelected(item);
    }
}
