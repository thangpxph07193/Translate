package com.example.myapplication.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.myapplication.database.TuDienDatabase;
import com.example.myapplication.model.LichSu;

import java.util.ArrayList;
import java.util.List;

public class LichSuDAO {
    public TuDienDatabase tuDienDatabase;
    public SQLiteDatabase db;
    public static final String TABLE_NAME_LS = "lichsu";
    public static final String CREATE_TABLE_LS =
            "CREATE TABLE lichsu(wordLS text primary key, nghiaLS text, phienAmLS text)";

    public LichSuDAO(Context context){
        tuDienDatabase = new TuDienDatabase(context);
        db= tuDienDatabase.getWritableDatabase();
    }
    public long insertLichSu(LichSu lichSu){
        ContentValues contentValues = new ContentValues();
        contentValues.put("wordLS", lichSu.wordLS);
        contentValues.put("nghiaLS",lichSu.nghiaLS);
        contentValues.put("phienAmLS",lichSu.phienAmLS);
        long rerult = db.insert(TABLE_NAME_LS,null, contentValues);
        return rerult;
    }
    public int deleteLichSu(String word){
        int result = db.delete(TABLE_NAME_LS,"wordLS=?", new String[]{word});
        return result;
    }

    public List<LichSu> getAllWordLichSu(){
        List<LichSu> lichSuList = new ArrayList<>();
        Cursor cursor = db.query(TABLE_NAME_LS,null,null,
                null, null, null,null);
        cursor.moveToFirst();
        while (cursor.isAfterLast()==false){
            LichSu lichSu = new LichSu();
            lichSu.setWordLS(cursor.getString(0));
            lichSu.setNghiaLS(cursor.getString(1));
            lichSu.setPhienAmLS(cursor.getString(2));

            lichSuList.add(lichSu);
            cursor.moveToNext();
        }
        cursor.close();
        return lichSuList;
    }
}
