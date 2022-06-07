package com.example.bd_app_tfc_alberto.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Empleados_DB extends SQLiteOpenHelper {
    private static final String TABLE_NAME = "empleados";
    private static final int DATABASE_VERSION = 1;

    private static final String ID = "id";
    private static final String NOMBRE = "nombre";
    private static final String FOTO = "foto";


    public Empleados_DB(@Nullable Context context) {
        super(context, TABLE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+TABLE_NAME+" ("+
                ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"+
                NOMBRE + " VARCHAR,"+
                FOTO + " VARCHAR)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }


}
