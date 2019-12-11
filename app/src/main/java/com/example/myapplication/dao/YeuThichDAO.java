package com.example.myapplication.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.myapplication.database.TuDienDatabase;
import com.example.myapplication.model.YeuThich;

import java.util.ArrayList;
import java.util.List;

public class YeuThichDAO {
    public TuDienDatabase tuDienDatabase;
    private SQLiteDatabase db;
    public static final String TABLE_NAME_YT ="yeuthich";
    public static final String CREATE_TABLE_YT= "CREATE TABLE yeuthich(wordYT text primary key, nghia text, phienAm text)";

    public YeuThichDAO(Context context){
        tuDienDatabase = new TuDienDatabase(context);
        db = tuDienDatabase.getWritableDatabase();
    }
    public long insertYT(YeuThich yeuThich){
        ContentValues contentValues = new ContentValues();
        contentValues.put("wordYT", yeuThich.wordYT);
        contentValues.put("nghia", yeuThich.nghia);
        contentValues.put("phienAm", yeuThich.phienAm);
        long result = db.insert(TABLE_NAME_YT, null,contentValues);
        return result;
    }
    public int deleteYT(String wordYT){
        int result = db.delete(TABLE_NAME_YT, "wordYT=?", new String[]{wordYT});
        return result;
    }
    public List<YeuThich> getAllWordYT(){
        List<YeuThich> yeuThichList = new ArrayList<>();
        Cursor cursor = db.query(TABLE_NAME_YT,null,
                null,null,null,null,null);
        cursor.moveToFirst();
        while (cursor.isAfterLast()==false){
            YeuThich yeuThich = new YeuThich();
            yeuThich.setWordYT(cursor.getString(0));
            yeuThich.setNghia(cursor.getString(1));
            yeuThich.setPhienAm(cursor.getString(2));

            yeuThichList.add(yeuThich);
            cursor.moveToNext();
        }
        cursor.close();
        return yeuThichList;
    }
}
