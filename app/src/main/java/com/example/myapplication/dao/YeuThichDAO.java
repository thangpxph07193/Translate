package com.example.myapplication.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.myapplication.database.TuDienDatabase;

public class YeuThichDAO {
    public TuDienDatabase tuDienDatabase;
    private SQLiteDatabase db;
    public static final String TABLE_NAME_YT ="yeuthich";
    public static final String CREATE_TABLE_YT= "CREATE TABLE yeuthich(wordYT text primary key, nghia text)";

    public YeuThichDAO(Context context){
        tuDienDatabase = new TuDienDatabase(context);
        db = tuDienDatabase.getWritableDatabase();
    }
}
