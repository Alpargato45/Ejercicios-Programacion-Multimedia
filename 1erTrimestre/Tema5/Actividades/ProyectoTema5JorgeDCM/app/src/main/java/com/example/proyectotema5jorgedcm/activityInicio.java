package com.example.proyectotema5jorgedcm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class activityInicio extends menuBase {

    private ImageView imagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla_inicio);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        imagen = findViewById(R.id.imagen);
        registerForContextMenu(imagen);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Puedes personalizar el menú aquí si es necesario
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // Puedes personalizar el manejo de ítems de menú aquí si es necesario
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_imagenes,menu);
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
        }
        return true;
    }
}