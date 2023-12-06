package com.example.ejemplopersonalizadocheck;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);

        ListView listado = findViewById(R.id.listado);
        final Button btn = findViewById(R.id);

        //Defino los datos
        ArrayList<Datos> datos = new ArrayList<Datos>();
        datos.add(new Datos("Texto 1",false));
        datos.add(new Datos("Texto 2",false));
        datos.add(new Datos("Texto 3",false));
        datos.add(new Datos("Texto 4",false));

        //Creo el adaptador
        Adaptador adaptador = new Adaptador(this,datos);
        listado.setAdapter(adaptador);

        // Creo el listener
        listado.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                int cont = 0;
                for (int i = 0; i <datos.size(); i++) {
                    if((datos.get(i)).isCheck()) {
                        cont++;
                    }
                }
                final TextView texto = findViewById(R.id.texto);
                texto.setText("Selecionado: " + cont + " Checboxs");
            }
        });

    }
}