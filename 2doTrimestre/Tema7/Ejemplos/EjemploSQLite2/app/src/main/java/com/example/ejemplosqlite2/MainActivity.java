package com.example.ejemplosqlite2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);

        //Obtengo los elementos del layout
        final TextView lblConsulta = findViewById(R.id.lblConsulta);
        final EditText codigo = findViewById(R.id.etCodigo);
        final EditText nombre = findViewById(R.id.etNombre);
        final Button btnInsertar = findViewById(R.id.btnInsertar);
        final Button btnActualizar = findViewById(R.id.btnActualizar);
        final Button btnBorrar = findViewById(R.id.btnBorrar);
        final Button btnConsultar = findViewById(R.id.btnConsultar);

        //Abrimos la base de datos en modo escritura
        UsuariosBBDD usuariosBBDD = new UsuariosBBDD(this,"BDUsuarios",null,1);
        SQLiteDatabase db = usuariosBBDD.getWritableDatabase();

        // Comprobamos que se ha abierto correctamente
        if(db!= null) {
            //Inserto los datos

            btnInsertar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String cod = codigo.getText().toString();
                    String usuario = nombre.getText().toString();

                    ContentValues registro = new ContentValues();
                    registro.put("codigo",cod);
                    registro.put("nombre",usuario);
                    db.insert("Usuarios",null,registro);
                }
            });

            //Borrar todos los datos
            btnBorrar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    db.execSQL("DELETE FROM Usuarios");
                }
            });

            //Actualizamos los datos
            btnActualizar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String cod = codigo.getText().toString();
                    String usuario = nombre.getText().toString();
                    String[] args = {usuario,cod};

                    db.execSQL("UPDATE Usuarios SET nombre=? WHERE codigo=?",args);
                }
            });

            //Consulto los datos
            btnConsultar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Cursor miCursor = db.rawQuery("SELECT codigo, nombre FROM Usuarios;",null);

                    lblConsulta.setText("");

                    if (miCursor.moveToFirst()) {
                        do {
                            String cod = miCursor.getString(0);
                            String usuario = miCursor.getString(1);
                            lblConsulta.append(cod + " " + usuario + "\n");
                        }while(miCursor.moveToNext());
                        miCursor.close();
                    }
                }
            });
        }
    }
}