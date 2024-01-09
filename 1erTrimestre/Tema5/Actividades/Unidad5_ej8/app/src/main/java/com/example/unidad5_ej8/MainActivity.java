package com.example.unidad5_ej8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ArrayList<Datos> datos = new ArrayList<Datos>();
        datos.add(new Datos(R.drawable.buho, "Buho"));
        datos.add(new Datos(R.drawable.cachorros, "Cachorros"));
        datos.add(new Datos(R.drawable.cerdo, "Cerdo"));
        datos.add(new Datos(R.drawable.jirafas, "Jirafas"));
        datos.add(new Datos(R.drawable.lobo, "Lobo"));
        datos.add(new Datos(R.drawable.potro, "Potro"));
        datos.add(new Datos(R.drawable.tigre, "Tigre"));
        datos.add(new Datos(R.drawable.tortuga, "Tortuga"));
        datos.add(new Datos(R.drawable.tucan, "Tucán"));


        GridView listado = findViewById(R.id.miLista);

        Adaptador miAdaptador = new Adaptador(this, datos);
        listado.setAdapter(miAdaptador);

        listado.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "El animal elegido es: " + datos.get(position).getTexto(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}