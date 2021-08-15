package com.example.ideasethu;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME ="USER_RECORD";
    private static final String TABLE_NAME = "USER_DATA";
    private static final String col_1 = "ID";
    private static final String col_2 = "username";
    private static final String col_3 = "email";
    private static final String col_4 = "password";

    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS " +TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT , username TEXT , email TEXT , password TEXT)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " +TABLE_NAME);
        onCreate(db);
    }

    public boolean registerUser(String username , String email, String password){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(col_2 , username);
        values.put(col_3 , email);
        values.put(col_4 , password);

        long result = db.insert(TABLE_NAME,null,values);
        if (result == -1)
            return false;
        else
            return true;

    }

    public boolean checkUser(String username, String password){

        SQLiteDatabase db = this.getWritableDatabase();
        String[] columns = { col_1 };
        String selection = col_2 + "=?" + " and " + col_4 + "=?";
        String[] selectionargs = { username , password };
        Cursor cursor = db.query(TABLE_NAME ,columns , selection , selectionargs, null, null,null);
        int count = cursor.getCount();
        db.close();
        cursor.close();
        if (count > 0)
            return true;
        else
            return false;

    }

}
