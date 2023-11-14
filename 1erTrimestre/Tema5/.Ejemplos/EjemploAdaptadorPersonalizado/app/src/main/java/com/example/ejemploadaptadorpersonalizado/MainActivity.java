package com.example.ejemploadaptadorpersonalizado;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);

        //Recupero el id del listado
        final ListView listado = findViewById(R.id.miLista);

        //Creo los datos
        Datos[] datos = new Datos[]{
                new Datos("Linea superior 1", "Linea inferior 1"),
                new Datos("Linea superior 2", "Linea inferior 2"),
                new Datos("Linea superior 3", "Linea inferior 3"),
                new Datos("Linea superior 4", "Linea inferior 4"),
                new Datos("Linea superior 5", "Linea inferior 5")
        };

        //Incorporo la cabecera al listado
        View miCabecera = getLayoutInflater().inflate(R.layout.cabecera,null);
        listado.addHeaderView(miCabecera);

        //Creo el adaptador
        Adaptador miAdaptador = new Adaptador(this,datos);
        listado.setAdapter(miAdaptador);

        //Inserto el lisener
        listado.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (view != miCabecera) {
                    String seleccionado = ((Datos) parent.getItemAtPosition(position)).getTexto1();
                    Toast.makeText(MainActivity.this, "Has pulsado " + seleccionado, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}