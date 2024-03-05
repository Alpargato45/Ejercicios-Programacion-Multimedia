package com.example.tema7ejercicio8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText nombre = findViewById(R.id.etNombre);
        final EditText apellidos = findViewById(R.id.etApellidos);

        final Button btnInsertar = findViewById(R.id.btnIns);
        final Button btnActualizar = findViewById(R.id.btnAct);
        final Button btnBorrar = findViewById(R.id.btnBorrar);
        final Button btnConsultar = findViewById(R.id.btnCons);

        final ListView listaPersonas = findViewById(R.id.listaPersonas);

        BBDD personaBBDD = new BBDD(this, "PersonasBBDD", null, 1);
        SQLiteDatabase db = personaBBDD.getWritableDatabase();

        if (db != null) {
            btnInsertar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String nombrePersona = nombre.getText().toString();
                    String apellidosPersona = apellidos.getText().toString();

                    ContentValues registro = new ContentValues();
                    registro.put("Nombre", nombrePersona);
                    registro.put("Apellido", apellidosPersona);

                    db.insert("Persona", null, registro);
                }
            });

            btnConsultar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Cursor miCursor = db.rawQuery("SELECT codigo,Nombre,Apellido FROM Persona;", null);
                    ArrayList<String> personas = new ArrayList<>();


                    if (miCursor.moveToFirst()) {
                        do {
                            String codigo = miCursor.getString(0);
                            String nombre = miCursor.getString(1);
                            String apellidos = miCursor.getString(2);

                            String persona = codigo + " " + nombre + " " + apellidos;
                            personas.add(persona);


                        } while (miCursor.moveToNext());

                        ArrayAdapter<String> introducirPersonas = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, personas);
                        listaPersonas.setAdapter(introducirPersonas);
                        miCursor.close();

                    }

                }
            });


            listaPersonas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    btnBorrar.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String texto = parent.getItemAtPosition(position).toString();
                            String[] elementos = texto.split(" ");
                            int codigo = Integer.parseInt(elementos[0]);
                            db.execSQL("DELETE FROM Persona WHERE codigo = " + codigo);

                        }
                    });
                }
            });

            listaPersonas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    btnActualizar.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String texto = parent.getItemAtPosition(position).toString();

                            String nuevoNombre = nombre.getText().toString();
                            String nuevosApellidos = apellidos.getText().toString();

                            ContentValues registro = new ContentValues();
                            registro.put("Nombre",nuevoNombre);
                            registro.put("Apellido",nuevosApellidos);

                            String[] elementos = texto.split(" ");
                            String codigo = elementos[0];

                            db.update("Persona",registro,"codigo=?",new String[]{String.valueOf(codigo)});

                        }
                    });
                }
            });


        }
    }
}