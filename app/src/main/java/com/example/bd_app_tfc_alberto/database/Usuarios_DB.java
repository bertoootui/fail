package com.example.bd_app_tfc_alberto.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Usuarios_DB extends SQLiteOpenHelper {

    private static final String TABLE_NAME = "users";
    private static final int DATABASE_VERSION = 1;

    private static final String ID = "id";
    private static final String NOMBRE = "nombre";
    private static final String EMAIL = "email";
    private static final String TLFN = "tlfn";
    private static final String PASSWORD = "password";

    public Usuarios_DB(@Nullable Context context) {
        super(context, TABLE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+TABLE_NAME + " ("+
                ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"+
                NOMBRE + " VARCHAR,"+
                EMAIL + " VARCHAR,"+
                TLFN + " INTEGER,"+
                PASSWORD + " VARCHAR)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }
}
