package com.example.examentema7jorgedcm.BaseDeDatos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class BDUsuarios extends SQLiteOpenHelper {

    String sqlCreate = "create table Peliculas(clave integer primary key autoincrement, nombre text, foto integer, lista integer)";

    public BDUsuarios(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sqlCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists Peliculas");

        db.execSQL(sqlCreate);
    }
}
