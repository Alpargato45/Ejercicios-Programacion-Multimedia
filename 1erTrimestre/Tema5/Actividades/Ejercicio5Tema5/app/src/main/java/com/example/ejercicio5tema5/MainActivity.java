package com.example.ejercicio5tema5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);

        final Spinner listaOpciones = findViewById(R.id.spinnerPeliculas);
        final TextView txtPelis = findViewById(R.id.txtPelicula);

        final String[] peliculas = {"Stranger Things","Cobra Kai", "A Korean Odyssey","Navidad en casa","Alquimia de almas","Desaparecido","Los Brigerton","Winx","Chernobyl"};

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,peliculas);
        listaOpciones.setAdapter(adaptador);

        listaOpciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String salida = parent.getItemAtPosition(position).toString();
                txtPelis.setText(salida);
            }
        });
    }
}