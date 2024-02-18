package com.example.examentema7jorgedcm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.example.examentema7jorgedcm.AdaptadorPersonalizado.Adaptador;
import com.example.examentema7jorgedcm.AdaptadorPersonalizado.Datos;
import com.example.examentema7jorgedcm.BaseDeDatos.BDUsuarios;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private int peliculaSeleccionada;
    private LinearLayout layoutAñadir;
    private LinearLayout layoutQuitar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);

        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final ListView listaTendencias = findViewById(R.id.listaTendencias);
        final ListView listaMiLista = findViewById(R.id.listaMiLista);
        final Button btnAñadir = findViewById(R.id.btnAñadirPelis);
        final Button btnCancelarAñadir = findViewById(R.id.btnCancelarAñadir);
        final Button btnQuitar = findViewById(R.id.btnQuitarPelis);
        final Button btnCancelarQUitar = findViewById(R.id.btnCancelarQuitar);

        layoutAñadir = findViewById(R.id.layoutAñadirPelis);
        layoutQuitar = findViewById(R.id.layoutQuitarPelis);

        BDUsuarios bdUsuarios = new BDUsuarios(this,"Peliculas",null,1);
        SQLiteDatabase db = bdUsuarios.getWritableDatabase();
        db.execSQL("delete from Peliculas");

        añadirBBDD(db);
        rellenarListaTendencias(db);
        rellenarListaMiLista(db);

        listaTendencias.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                layoutAñadir.setVisibility(View.VISIBLE);
                layoutQuitar.setVisibility(View.GONE);

                peliculaSeleccionada = ((Datos) parent.getItemAtPosition(position)).getClave();
            }
        });

        listaMiLista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                layoutQuitar.setVisibility(View.VISIBLE);
                layoutAñadir.setVisibility(View.GONE);

                peliculaSeleccionada = ((Datos) parent.getItemAtPosition(position)).getClave();
            }
        });

        btnAñadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] args = new String[] {String.valueOf(peliculaSeleccionada)};
                Cursor c = db.rawQuery("select * from Peliculas where clave =?",args);
                if (c.moveToFirst()) {
                    String nombre = c.getString(1);
                    int foto = c.getInt(2);
                    int lista = c.getInt(3);

                    ContentValues registro = new ContentValues();
                    registro.put("nombre",nombre);
                    registro.put("foto",foto);
                    registro.put("lista",1);
                    db.update("Peliculas",registro,"clave="+peliculaSeleccionada,null);
                }
                rellenarListaMiLista(db);
                cancelar();
            }
        });

        btnQuitar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] args = new String[] {String.valueOf(peliculaSeleccionada)};
                Cursor c = db.rawQuery("select * from Peliculas where clave =?",args);
                if (c.moveToFirst()) {
                    db.execSQL("delete from Peliculas where clave="+peliculaSeleccionada);
                }

                rellenarListaMiLista(db);
                cancelar();
            }
        });

        btnCancelarAñadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelar();
            }
        });

        btnCancelarQUitar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelar();
            }
        });

    }

    private void cancelar() {
        layoutAñadir.setVisibility(View.INVISIBLE);
        layoutQuitar.setVisibility(View.GONE);
    }

    private void rellenarListaTendencias(SQLiteDatabase db) {
        Cursor c = db.rawQuery("select * from Peliculas where lista = 0",null);
        ListView listado = (ListView) findViewById(R.id.listaTendencias);
        ArrayList<Datos> datos = new ArrayList<>();
        if (c.moveToFirst()) {
            do {
                int clave = c.getInt(0);
                String nombre = c.getString(1);
                int foto = c.getInt(2);
                int lista = c.getInt(3);
                Datos datos1 = new Datos(clave,nombre,foto,lista);
                datos.add(datos1);
            }while (c.moveToNext());
        }
        Adaptador miAdaptador = new Adaptador(this,datos);
        listado.setAdapter(miAdaptador);
    }

    private void rellenarListaMiLista(SQLiteDatabase db) {
        Cursor c = db.rawQuery("select * from Peliculas where lista = 1", null);
        ListView listado = (ListView) findViewById(R.id.listaMiLista);
        ArrayList<Datos> datos = new ArrayList<>();
        if (c.moveToFirst()) {
            do {
                int clave = c.getInt(0);
                String nombre = c.getString(1);
                int foto = c.getInt(2);
                int lista = c.getInt(3);
                Datos datos1 = new Datos(clave, nombre, foto, lista);
                datos.add(datos1);
            } while (c.moveToNext());
        }
        Adaptador miAdaptador = new Adaptador(this, datos);
        listado.setAdapter(miAdaptador);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.configuracion,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemID = item.getItemId();
        Intent intent;
        if (itemID == R.id.Configuración) {
            intent = new Intent(MainActivity.this,activityConfiguracion.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    private void añadirBBDD(SQLiteDatabase db) {
        ContentValues nuevoRegistro = new ContentValues();
        nuevoRegistro.put("nombre","stranger");
        nuevoRegistro.put("foto",R.drawable.stranger);
        nuevoRegistro.put("lista",0);
        db.insert("Peliculas",null,nuevoRegistro);

        nuevoRegistro.put("nombre","supernatural");
        nuevoRegistro.put("foto",R.drawable.supernatural);
        nuevoRegistro.put("lista",0);
        db.insert("Peliculas",null,nuevoRegistro);

        nuevoRegistro.put("nombre","Shingeki no Kyojin");
        nuevoRegistro.put("foto",R.drawable.titanes);
        nuevoRegistro.put("lista",0);
        db.insert("Peliculas",null,nuevoRegistro);

        nuevoRegistro.put("nombre","breaking");
        nuevoRegistro.put("foto",R.drawable.breaking);
        nuevoRegistro.put("lista",0);
        db.insert("Peliculas",null,nuevoRegistro);

        nuevoRegistro.put("nombre","broadchurch");
        nuevoRegistro.put("foto",R.drawable.broadchurch);
        nuevoRegistro.put("lista",0);
        db.insert("Peliculas",null,nuevoRegistro);

        nuevoRegistro.put("nombre","hill");
        nuevoRegistro.put("foto",R.drawable.hill);
        nuevoRegistro.put("lista",0);
        db.insert("Peliculas",null,nuevoRegistro);

        nuevoRegistro.put("nombre","howl");
        nuevoRegistro.put("foto",R.drawable.howl);
        nuevoRegistro.put("lista",0);
        db.insert("Peliculas",null,nuevoRegistro);

        nuevoRegistro.put("nombre","lucifer");
        nuevoRegistro.put("foto",R.drawable.lucifer);
        nuevoRegistro.put("lista",0);
        db.insert("Peliculas",null,nuevoRegistro);

        nuevoRegistro.put("nombre","alquimia");
        nuevoRegistro.put("foto",R.drawable.alquimia);
        nuevoRegistro.put("lista",0);
        db.insert("Peliculas",null,nuevoRegistro);

        nuevoRegistro.put("nombre","erased");
        nuevoRegistro.put("foto",R.drawable.erased);
        nuevoRegistro.put("lista",0);
        db.insert("Peliculas",null,nuevoRegistro);
    }
}