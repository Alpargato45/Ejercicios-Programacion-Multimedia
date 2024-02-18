package com.example.apimusica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class ActivityBusqueda extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_busqueda);

        final EditText textoBusqueda = findViewById(R.id.etBusqueda);
        final Spinner spinnerBusqueda = findViewById(R.id.spinnerBusqueda);
        final Button btnBuscar = findViewById(R.id.btnBusqueda);

        final String[] datosSpinner = {"Canción","Cantante"};
        ArrayAdapter<String> adaptador = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,datosSpinner);
        spinnerBusqueda.setAdapter(adaptador);

        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (spinnerBusqueda.getSelectedItem().equals("Canción")) {
                    String textoCancion = textoBusqueda.getText().toString();
                    Intent intent = new Intent(ActivityBusqueda.this,ActivityCancion.class);
                    intent.putExtra("cancion",textoCancion);
                    startActivity(intent);
                }else if (spinnerBusqueda.getSelectedItem().equals("Cantante")) {
                    String textoArtista = textoBusqueda.getText().toString();
                    Intent intent = new Intent(ActivityBusqueda.this, ActivityArtista.class);
                    intent.putExtra("artista",textoArtista);
                    startActivity(intent);
                }
            }
        });
    }
}