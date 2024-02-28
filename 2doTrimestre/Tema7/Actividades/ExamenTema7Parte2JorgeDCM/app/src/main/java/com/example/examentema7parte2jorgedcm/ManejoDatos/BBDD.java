package com.example.examentema7parte2jorgedcm.ManejoDatos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class BBDD extends SQLiteOpenHelper {

    String sqlCreate = "CREATE TABLE Contactos(_id INTEGER PRIMARY KEY AUTOINCREMENT,nombre TEXT, telefono TEXT, personaje INTEGER)";

    public BBDD(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sqlCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS Contactos");
        db.execSQL(sqlCreate);
    }
}