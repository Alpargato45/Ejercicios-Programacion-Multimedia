package com.example.ejemplogridview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);

        //Recupero el id del listado
        final GridView listado = findViewById(R.id.miGrid);

        //Defino la fuente de datos
        final String[] datos = {"Elemento1","Elemento2","Elemento3","Elemento4","Elemento5"};

        //Creo el adaptador
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,datos);
        listado.setAdapter(adaptador);

        //Asigno el manejador de eventos
        listado.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Obtenemos el texto del elemento usado

                //Modo 1 (pero bueno)
                Toast.makeText(MainActivity.this, "Has pulsado " + parent.getItemAtPosition(position), Toast.LENGTH_SHORT).show();

                //Modo 2 (También Bueno)
                Toast.makeText(MainActivity.this, "Has pulsado " + parent.getAdapter().getItem(position), Toast.LENGTH_SHORT).show();
            }
        });

    }
}