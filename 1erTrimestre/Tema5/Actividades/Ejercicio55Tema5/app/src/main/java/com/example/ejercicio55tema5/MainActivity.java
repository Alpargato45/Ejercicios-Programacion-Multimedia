package com.example.ejercicio55tema5;

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

        final ListView listadoTelefonico = findViewById(R.id.lista);

        Datos[] datos = new Datos[]{
                new Datos("Jorge", "123456789"),
                new Datos("Dani", "231456853")
        };

        View cabecera = getLayoutInflater().inflate(R.layout.cabecera,null);
        listadoTelefonico.addHeaderView(cabecera);

        Adaptador miAdaptador = new Adaptador(this,datos);
        listadoTelefonico.setAdapter(miAdaptador);

        listadoTelefonico.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (view != cabecera) {
                    String seleccionado = ((Datos) parent.getItemAtPosition(position)).getTexto1();
                    Toast.makeText(MainActivity.this, "Has pulsado " + seleccionado, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}