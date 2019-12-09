package com.example.myapplication.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.myapplication.database.TuDienDatabase;
import com.example.myapplication.model.LichSu;

public class LichSuDAO {
    public TuDienDatabase tuDienDatabase;
    public SQLiteDatabase db;
    public static final String TABLE_NAME_LS = "lichsu";
    public static final String CREATE_TABLE_LS =
            "CREATE TABLE lichsu(wordLS text primary key, nghiaLS text)";

    public LichSuDAO(Context context){
        tuDienDatabase = new TuDienDatabase(context);
        db= tuDienDatabase.getWritableDatabase();
    }
    public long insertLichSu(LichSu lichSu){
        ContentValues contentValues = new ContentValues();
        contentValues.put("wordLS", lichSu.wordLS);
        contentValues.put("nghiaLS",lichSu.nghiaLS);
        long rerult = db.insert(TABLE_NAME_LS,null, contentValues);
        return rerult;
    }
}
