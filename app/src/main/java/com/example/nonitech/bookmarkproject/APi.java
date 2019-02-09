package com.example.nonitech.bookmarkproject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APi {
    //root url
    String BASE_URL="http://androdoze.tk/Bookmark/";

    //call api(retrivedata.php)
    @GET("retrivedata.php")
    Call<List<BookmarkModel>> getBookmarData();

}
