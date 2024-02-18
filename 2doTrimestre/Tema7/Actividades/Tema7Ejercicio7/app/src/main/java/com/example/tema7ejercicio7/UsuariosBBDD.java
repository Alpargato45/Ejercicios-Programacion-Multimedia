package com.example.tema7ejercicio7;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class UsuariosBBDD extends SQLiteOpenHelper {

    String sqlCreate = "CREATE TABLE Usuarios(codigo INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT,apellidos TEXT)";

    public UsuariosBBDD(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sqlCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS Usuarios");
        db.execSQL(sqlCreate);
    }
}
