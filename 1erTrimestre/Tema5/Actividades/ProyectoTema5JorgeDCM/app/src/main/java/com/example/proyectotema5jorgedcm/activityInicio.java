package com.example.proyectotema5jorgedcm;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.ActionMenuItem;
import androidx.appcompat.widget.Toolbar;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.proyectotema5jorgedcm.Herencias.MenuBase;

import java.util.ArrayList;
import java.util.Random;

public class activityInicio extends MenuBase {

    private ImageView imagen;
    private ListView listaTextos;
    private int posTexto = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla_inicio);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        imagen = findViewById(R.id.imagen);
        registerForContextMenu(imagen);

        listaTextos = findViewById(R.id.ListViewTextos);

        ArrayList<String> datos = new ArrayList<>();
        datos.add("Mis animales favoritos son los leopardos y los zorros, ¡prueba a pulsar en esta imagen a ver que pasa!");
        datos.add("Cuando tenía 4 años quería estudiar Biología!!");
        datos.add("Pulsa sobre este texto, ¡a lo mejor ocurre algo!");
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,datos);
        listaTextos.setAdapter(adaptador);
        registerForContextMenu(listaTextos);

        listaTextos.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                posTexto = position;
                //No se si esto está bien hecho pero es la única forma que he encontrado de poder hacer las dos cosas
                openContextMenu(listaTextos);
                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View view, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, view, menuInfo);
        if (view == imagen) {
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.menu_imagenes, menu);
        } else if (view == listaTextos) {
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.menu_listview, menu);
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        int opcion = item.getItemId();
        if(opcion == R.id.imagenEsquema) {
            imagen.setImageResource(R.drawable.arbol_reino_animal);
        }else if (opcion == R.id.imagenZorro) {
            imagen.setImageResource(R.drawable.icono_app);
        }else if (opcion == R.id.imagenLeopardo) {
            imagen.setImageResource(R.drawable.leopardo_nevado);
        }else if (opcion == R.id.mnOpCambioColor) {
            Random random = new Random();
            int red = random.nextInt(256);
            int green = random.nextInt(256);
            int blue = random.nextInt(256);

            ((TextView) listaTextos.getChildAt(posTexto)).setTextColor(Color.rgb(red, green, blue));
        }
        return true;
    }
}