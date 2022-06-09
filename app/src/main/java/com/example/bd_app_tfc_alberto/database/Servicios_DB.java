package com.example.bd_app_tfc_alberto.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.bd_app_tfc_alberto.clases.Servicios;

import java.util.ArrayList;

public class Servicios_DB extends SQLiteOpenHelper {

    private static final String TABLE_NAME = "servicios";
    private static final int DATABASE_VERSION = 1;
    private static final String ID = "id";
    private static final String NOMBRE = "nombre";
    private static final String PRECIO = "precio";

    public Servicios_DB(@Nullable Context context) {
        super(context, TABLE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+ TABLE_NAME + " ("+
                ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"+
                NOMBRE + " VARCHAR,"+
                PRECIO + " VARCHAR)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        onCreate(db);

    }

    public void setData()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        onUpgrade(db,1,1);
        ContentValues contentValues = new ContentValues();
        for(int i =0;i<6;i++)
        {
            contentValues.put("nombre","corte"+i);
            contentValues.put("precio","15,00€");
            db.insert(TABLE_NAME,null,contentValues);
        }
    }

    public ArrayList<Servicios> getData()
    {
        ArrayList<Servicios> listaserv = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT nombre, precio FROM servicios",new String[]{});
        if(c.moveToFirst()){
            do{
                listaserv.add(new Servicios(c.getString(0), c.getString(1)));

            }while (c.moveToNext());

        }
        return listaserv;
    }

    public String getServName(int id_serv) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT nombre FROM servicios WHERE id = ?",new String[]{String.valueOf(id_serv)});
        if(c.moveToFirst())
        {
            return c.getString(0);
        }else return "";
    }
}
