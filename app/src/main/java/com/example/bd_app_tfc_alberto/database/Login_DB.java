package com.example.bd_app_tfc_alberto.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Base64;

import androidx.annotation.Nullable;

public class Login_DB extends SQLiteOpenHelper {
    private static final String TABLE_NAME = "login";
    private static final int DATABASE_VERSION = 1;
    private static final String ID = "id";
    private static final String EMAIL = "email";
    private static final String PASSWORD = "password";


    public Login_DB(@Nullable Context context) {
        super(context, TABLE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+ TABLE_NAME +" ("+
                ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"+
                EMAIL + " VARCHAR UNIQUE,"+
                PASSWORD +" VARCHAR)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }

    public void register(String email, String password)
    {
        password = Base64.decode(password,Base64.DEFAULT).toString();
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email",email);
        contentValues.put("password",password);
        db.insert(TABLE_NAME,null,contentValues);
    }

    public String getLogin(String email, String password)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT email, password FROM login WHERE email = ?",new String[]{email});
        if(c.moveToFirst())
        {
            String pass = c.getString(1);
            String email1 = c.getString(0);
            if(!password.equals(pass))
            {
                return "Contraseña incorrecta";
            }
            else
            {
                return "Login correcto";
            }
        }
        else return "Email incorrecto";
    }
}
