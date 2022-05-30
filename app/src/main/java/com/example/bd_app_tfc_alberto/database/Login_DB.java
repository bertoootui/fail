package com.example.bd_app_tfc_alberto.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Base64;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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

    public boolean register(String email, String password)
    {


        String password1 = MD5_Hash(password);
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email",email);
        contentValues.put("password",password1);
        db.insert(TABLE_NAME,null,contentValues);
        return true;
    }

    public String getLogin(String email, String password)
    {

        String password1 = MD5_Hash(password);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT email, password FROM login WHERE email = ?",new String[]{email});
        if(c.moveToFirst())
        {
            String pass = c.getString(1);
            Log.i("password",password1);


            String email1 = c.getString(0);
            if(!pass.equals(password1))
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


    public static String MD5_Hash(String s) {
        MessageDigest m = null;

        try {
            m = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        m.update(s.getBytes(),0,s.length());
        String hash = new BigInteger(1, m.digest()).toString(16);
        return hash;
    }
}
