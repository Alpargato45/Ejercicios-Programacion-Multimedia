package com.example.tema7ejercicio7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);

        final LinearLayout actBorr = findViewById(R.id.linearActBorr);
        final EditText txtNombre = findViewById(R.id.txtNombre);
        final EditText txtApellido = findViewById(R.id.txtApellido);
        final EditText txtCodigo = findViewById(R.id.txtCodigo);
        final TextView texto = findViewById(R.id.txtRespuesta);

        final Button btnInsertar = findViewById(R.id.btnInsertar);
        final Button btnConsultar = findViewById(R.id.btnCons);
        final Button btnActBorr = findViewById(R.id.btnActBorr);
        final Button btnBorrar = findViewById(R.id.btnBorrar);
        final Button btnActualizar = findViewById(R.id.btnActualizar);

        UsuariosBBDD usuariosBBDD = new UsuariosBBDD(this,"BDUsuarios",null,1);
        SQLiteDatabase db = usuariosBBDD.getWritableDatabase();

        if(db!= null) {

            btnInsertar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    actBorr.setVisibility(View.GONE);
                    String nombre = txtNombre.getText().toString();
                    String apellidos = txtApellido.getText().toString();

                    ContentValues registro = new ContentValues();
                    registro.put("nombre",nombre);
                    registro.put("apellidos",apellidos);
                    db.insert("Usuarios",null,registro);
                    Toast.makeText(MainActivity.this, "Usuario Insertado Correctamente", Toast.LENGTH_SHORT).show();
                }
            });

            btnActBorr.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    actBorr.setVisibility(View.VISIBLE);
                }
            });

            btnActualizar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String codigo = txtCodigo.getText().toString();
                    String nombre = txtNombre.getText().toString();
                    String apellidos = txtApellido.getText().toString();
                    String[] args = {nombre,apellidos,codigo};

                    db.execSQL("update Usuarios set nombre=?, apellidos=? where codigo=?",args);
                    Toast.makeText(MainActivity.this, "Usuario Eliminado Correctamente", Toast.LENGTH_SHORT).show();
                }
            });

            btnBorrar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String cod = txtCodigo.getText().toString();
                    db.execSQL("delete from Usuarios where codigo = " + cod);
                    Toast.makeText(MainActivity.this, "Usuario Eliminado Correctamente", Toast.LENGTH_SHORT).show();
                }
            });

            btnConsultar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    actBorr.setVisibility(View.GONE);
                    Cursor miCursor = db.rawQuery("select * from Usuarios;",null);
                    texto.setText("");

                    if(miCursor.moveToFirst()) {
                        do {
                            String codigo = miCursor.getString(0);
                            String nombre = miCursor.getString(1);
                            String apellidos = miCursor.getString(2);
                            texto.append(codigo + " " + nombre + " " + apellidos + "\n");
                        }while (miCursor.moveToNext());
                        miCursor.close();
                    }
                }
            });

        }
    }
}