package com.example.unidad5_ej9;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Defino los datos

        ArrayList<Datos> datos = new ArrayList<Datos>();
        Button boton = findViewById(R.id.miBoton);

        datos.add(new Datos(R.drawable.tv, false, "Televisión"));
        datos.add(new Datos(R.drawable.smartphone, false, "Teléfono móvil"));
        datos.add(new Datos(R.drawable.tablet, false, "Tablet"));
        datos.add(new Datos(R.drawable.ordenador_fijo, false, "Ordenador fijo"));
        datos.add(new Datos(R.drawable.ordenador_portatil, false, "Ordenador portatil"));
        datos.add(new Datos(R.drawable.reloj, false, "Reloj"));

        ListView listado = findViewById(R.id.miLista);

        Adaptador miAdaptador = new Adaptador(this, datos);
        listado.setAdapter(miAdaptador);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int contador = 0;
                String salida = "Para navegar por internet utilizas ";

                ArrayList<String> elementosSeleccionados = new ArrayList<>();


                for (int i = 0; i < datos.size(); i++) {

                    if (datos.get(i).isSelected()) {

                        if (datos.get(i).getTexto().equals("Televisión") || datos.get(i).getTexto().equals("Tablet")) {
                            elementosSeleccionados.add("la " + datos.get(i).getTexto());
                        } else {
                            elementosSeleccionados.add("el " + datos.get(i).getTexto());
                        }
                    }
                }

                for (int i = 0; i < elementosSeleccionados.size(); i++) {

                    contador++;
                    if (contador == 1) {
                        salida += elementosSeleccionados.get(i);
                    } else if (contador > 1 && contador < elementosSeleccionados.size()) {

                        salida += " , " + elementosSeleccionados.get(i);

                    } else if (contador > 1 && contador == elementosSeleccionados.size()) {

                        salida += " y ";

                        salida += elementosSeleccionados.get(i);

                    }
                }

                if (contador == 0) {
                    salida = "No has seleccionado ninguna opción";
                }
                Toast.makeText(MainActivity.this, salida, Toast.LENGTH_SHORT).show();
            }
        });


    }
}