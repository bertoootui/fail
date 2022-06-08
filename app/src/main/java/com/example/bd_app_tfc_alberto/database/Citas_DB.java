package com.example.bd_app_tfc_alberto.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Citas_DB extends SQLiteOpenHelper {

    private static final String TABLE_NAME = "citas";
    private static final int DATABASE_VERSION = 1;

    private static final String ID = "id";
    private static final String ID_USER = "id_user";
    private static final String DATE = "date";
    private static final String TIME = "time";

    public Citas_DB(@Nullable Context context) {
        super(context, TABLE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+TABLE_NAME+" ("+
                ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"+
                ID_USER + " INTEGER,"+
                DATE + " VARCHAR,"+
                TIME +" VARCHAR)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }

    public void addDate(String date,String time, int id_user)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("date",date);
        contentValues.put("time",time);
        contentValues.put("id_user",id_user);
        db.insert(TABLE_NAME,null,contentValues);
    }


}
