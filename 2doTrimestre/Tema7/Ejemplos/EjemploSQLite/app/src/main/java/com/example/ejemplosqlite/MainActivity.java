package com.example.ejemplosqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Abrimos la base de datos en modo escritura
        UsuariosBBDD usuariosBBDD = new UsuariosBBDD(this,"BDUsuarios",null,1);
        SQLiteDatabase db = usuariosBBDD.getWritableDatabase();

        if(db != null) {
            //Inserto 5 usuarios
            String usuario;
            for (int i = 0; i < 5; i++) {
                usuario = "Usuario" + i;
                db.execSQL("INSERT INTO Usuarios(codigo,nombre) VALUES " + i + ", '" + usuario + "')" );
            }
        }
    }
}