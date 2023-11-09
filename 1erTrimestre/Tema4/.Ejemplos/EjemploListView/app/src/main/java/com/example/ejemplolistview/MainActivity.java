package com.example.ejemplolistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);

        //Recupero el elemento del layout y defino los valores del listado
        final ListView listaOpciones = findViewById(R.id.listaOpciones);

        String[] datos = {"Opción 1", "Opción 2", "Opción 3"};

        //Creo el adaptador
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,datos);

        //Asigno el adaptador
        listaOpciones.setAdapter(adaptador);

        //Defino el manejador de eventos
        listaOpciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //Manera de la que nunca hay que hacerlo
                //Toast.makeText(MainActivity.this, "Has hecho Click en " + datos[position], Toast.LENGTH_SHORT).show();

                //Modo 2, uno de los buenos. Obtenemos el elemento del listado
                Toast.makeText(MainActivity.this, "Has hecho click en " + listaOpciones.getItemAtPosition(position), Toast.LENGTH_SHORT).show();

                //Modo 3, otro bueno. Obtenemos el elemento del adaptador
                //Toast.makeText(MainActivity.this, "Has hecho click en " + listaOpciones.getAdapter().getItem(position), Toast.LENGTH_SHORT).show();

            }
        });

    }
}