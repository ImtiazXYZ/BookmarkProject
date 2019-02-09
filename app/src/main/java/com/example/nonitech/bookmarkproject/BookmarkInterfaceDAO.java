package com.example.nonitech.bookmarkproject;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;
@Dao
public interface BookmarkInterfaceDAO {

    @Insert(onConflict = OnConflictStrategy.FAIL)
    void insert(BookMarkTable bookMarkTable);

    @Insert
    void  insertAll(BookMarkTable... bookMarkTable);

    @Query("select * from bookmark_table")
    public List<BookMarkTable>getAllData();
}
