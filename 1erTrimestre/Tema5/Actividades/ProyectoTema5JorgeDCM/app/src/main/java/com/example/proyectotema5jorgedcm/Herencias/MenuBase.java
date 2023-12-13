package com.example.proyectotema5jorgedcm.Herencias;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.proyectotema5jorgedcm.Animales.Artropodo;
import com.example.proyectotema5jorgedcm.Animales.Aves;
import com.example.proyectotema5jorgedcm.Animales.Mamiferos;
import com.example.proyectotema5jorgedcm.R;

public abstract class MenuBase extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_inicio,menu);
        return true;
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        Intent cambioPantalla;

        if (itemId == R.id.mnOpMamiferos) {
            cambioPantalla = new Intent(this, Mamiferos.class);
            startActivity(cambioPantalla);
            return true;
        } else if (itemId == R.id.mnOpAves) {
            cambioPantalla = new Intent(this, Aves.class);
            startActivity(cambioPantalla);
        } else if (itemId == R.id.mnOpArtropodos) {
            cambioPantalla = new Intent(this, Artropodo.class);
            startActivity(cambioPantalla);
        }
        return super.onOptionsItemSelected(item);
    }
}