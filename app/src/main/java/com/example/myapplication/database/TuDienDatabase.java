package com.example.myapplication.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.myapplication.model.Word;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TuDienDatabase extends SQLiteOpenHelper implements DataMVP {

    private static String TAG = "TuDienDatabase";
    //tên cơ sở dữ liệu
    public static String DB_NAME = "dict_hh.db";
    //dịa chỉ lưu trữ CSDL
    public static String DB_PATH;
    private SQLiteDatabase mDataBase;
    private final Context mContext;

    private String AV_TABLE = "av";
    private String VA_TABLE = "va";

    public String ID = "id";
    public String WORD = "word";
    public String HTML = "html";
    public String DES = "description";
    public String PRO = "pronounce";



    public TuDienDatabase(Context context) {
        super(context, DB_NAME, null, 1);

        if (Build.VERSION.SDK_INT >= 17){
            DB_PATH = context.getApplicationInfo().dataDir + "/databases/";
        }else {
            DB_PATH = "/data/data/" + context.getPackageName() + "/databases/";
        }
        this.mContext = context;
    }

    @Override
    public boolean checkDataBase() {
        File dbFile = new File(DB_PATH + DB_NAME);
        return dbFile.exists();
    }

    @Override
    public void copyDataBase() throws IOException {
        InputStream mInput = mContext.getAssets().open(DB_NAME);
        String outFileName = DB_PATH + DB_NAME;
        OutputStream mOutput = new FileOutputStream(outFileName);
        byte[] mBuffer = new byte[1024];
        int mLength;
        while ((mLength = mInput.read(mBuffer)) > 0) {
            mOutput.write(mBuffer, 0, mLength);
        }
        mOutput.flush();
        mOutput.close();
        mInput.close();
    }




    @Override
    public void createDataBase() {
        boolean mDataBaseExits = checkDataBase();
        if (!mDataBaseExits){
            this.getReadableDatabase();
            this.close();
            try {
                copyDataBase();
                Log.e(TAG, "createDatabase database created");
            }catch (IOException mIOException){
                throw new Error("ErrorCopyingDataBase");
            }
        }
    }
    @Override
    public boolean openDataBase() throws SQLException {
        String mPath = DB_PATH + DB_NAME;
        //Log.v("mPath", mPath);
        mDataBase = SQLiteDatabase.openDatabase(mPath, null, SQLiteDatabase.CREATE_IF_NECESSARY);
        //mDataBase = SQLiteDatabase.openDatabase(mPath, null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
        return mDataBase !=null;
    }

    @Override
    public synchronized void close() {
        if (mDataBase !=null)
            mDataBase.close();
        super.close();
    }
    public List<Word> searchWord(String text) {
        List<Word> words = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        String SQL = "SELECT * FROM " + AV_TABLE + " WHERE " + WORD + " LIKE '" + text + "%'";

        Cursor cursor = sqLiteDatabase.rawQuery(SQL, null);

        if (cursor != null) {
            if (cursor.getCount() > 0) {

                cursor.moveToFirst();
                while (!cursor.isAfterLast()) {

                    Word word = new Word();
                    word.id = cursor.getInt(cursor.getColumnIndex(ID));
                    word.word = cursor.getString(cursor.getColumnIndex(WORD));
                    word.description = cursor.getString(cursor.getColumnIndex(DES));
                    word.html = cursor.getString(cursor.getColumnIndex(HTML));
                    word.pronounce = cursor.getString(cursor.getColumnIndex(PRO));
                    words.add(word);
                    cursor.moveToNext();

                }
                cursor.close();
            }
        }

        return words;
    }
    public List<Word> searchVA(String text) {
        List<Word> words = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        String SQL = "SELECT * FROM " + VA_TABLE + " WHERE " + WORD + " LIKE '" + text + "%'";

        Cursor cursor = sqLiteDatabase.rawQuery(SQL, null);

        if (cursor != null) {
            if (cursor.getCount() > 0) {

                cursor.moveToFirst();
                while (!cursor.isAfterLast()) {

                    Word word = new Word();
                    word.id = cursor.getInt(cursor.getColumnIndex(ID));
                    word.word = cursor.getString(cursor.getColumnIndex(WORD));
                    word.description = cursor.getString(cursor.getColumnIndex(DES));
                    word.html = cursor.getString(cursor.getColumnIndex(HTML));
                    word.pronounce = cursor.getString(cursor.getColumnIndex(PRO));
                    words.add(word);
                    cursor.moveToNext();

                }
                cursor.close();
            }
        }

        return words;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


}
