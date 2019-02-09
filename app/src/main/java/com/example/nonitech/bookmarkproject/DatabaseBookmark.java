package com.example.nonitech.bookmarkproject;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {BookMarkTable.class},version = 1, exportSchema = false)
public abstract class DatabaseBookmark extends RoomDatabase {


    public abstract BookmarkInterfaceDAO bookmarkInterfaceDAO();


}
