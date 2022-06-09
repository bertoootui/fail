package com.example.bd_app_tfc_alberto.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

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
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        onCreate(db);

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


    public ArrayList<String> getTimes(ArrayList<String> listatime,String date,int id_emp) {
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor c = db.rawQuery("SELECT time FROM citas WHERE ID_EMP = ? AND DATE = ?",new String[]{String.valueOf(id_emp),date});
        if(c.moveToFirst())
        {
            do{
                String time = c.getString(0);
                for(int i = 0; i<listatime.size();i++)
                {
                    if(time.equals(listatime.get(i))) listatime.remove(i);
                }
            }while (c.moveToNext());
        }
        return listatime;
    }
}
