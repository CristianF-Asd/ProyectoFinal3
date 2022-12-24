package com.example.proyectofinal1.BasedeDatos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBConnector extends SQLiteOpenHelper {

    public DBConnector(Context context) {
        super(context, "DB", null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table userInfo(UserName VARCHAR, " +
                "Email VARCHAR unique, Password VARCHAR)");

    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        if(i<i1){
            sqLiteDatabase.execSQL("create table reciInfo(Cant0 INTEGER, " +
                    "Cant1 INTEGER, Cant2 INTEGER, Cant3 INTEGER, Cant4 INTEGER," +
                    " Email VARCHAR,  Fecha DEFAULT CURRENT_DATE)");

        }
    }
}
