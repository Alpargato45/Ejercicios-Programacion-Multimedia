package com.example.ejemplocontentprovider;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class ClientesBBDD extends SQLiteOpenHelper {

    String sqlCreate = "create table Clientes( _id integer primary key autoincrement, nombre text, telefono text, email text)";

    public ClientesBBDD(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Creamos la tabla
        db.execSQL(sqlCreate);

        //Por simplicidad del ejemplo, insertamos directamente clientes
        for (int i = 1; i < 10; i++) {
            //Genero los datos
            String nombre = "Cliente " + i;
            String telefono = "400-342-23" + i;
            String email = "email" + i + "@gmail.com";

            //Insertamos los datos en la tabla clientes
            ContentValues registro = new ContentValues();
            registro.put("nombre",nombre);
            registro.put("telefono",telefono);
            registro.put("email",email);
            db.insert("Clientes",null,registro);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("drop table if exists Clientes");
        db.execSQL(sqlCreate);

    }
}
