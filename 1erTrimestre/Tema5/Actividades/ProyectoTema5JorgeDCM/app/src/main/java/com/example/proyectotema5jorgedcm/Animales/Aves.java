package com.example.proyectotema5jorgedcm.Animales;

import androidx.annotation.NonNull;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import com.example.proyectotema5jorgedcm.Adaptador.Adaptador;
import com.example.proyectotema5jorgedcm.Adaptador.Datos;
import com.example.proyectotema5jorgedcm.R;
import com.example.proyectotema5jorgedcm.Herencias.MenuBase;

public class Aves extends MenuBase {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aves);

        final ListView listaAve = findViewById(R.id.listViewAves);
        Toolbar toolbar = findViewById(R.id.toolbarAves);
        setSupportActionBar(toolbar);

        Datos[] datos = new Datos[]{
                new Datos(R.drawable.halcon,"Halcón","Los halcones son aves rapaces ágiles con alas afiladas y visión excepcional." +
                        " Cazadores expertos en vuelo, desempeñan un papel vital en la cadena alimentaria como depredadores tope." +
                        " Su presencia se extiende por diversos hábitats, y destacan por su elegancia y adaptabilidad.",R.raw.hawk),
                new Datos(R.drawable.aguila,"Águila",
                        "El águila, majestuosa ave rapaz, destaca por sus alas fuertes y garras afiladas. Con aguda visión, " +
                        "caza con destreza tanto en tierra como en vuelo. Presente en diversos hábitats alrededor del mundo, simboliza fuerza y libertad. " +
                        "Desempeña un papel esencial como depredador tope en los ecosistemas.",R.raw.eagle),
                new Datos(R.drawable.colibri,"Colibrí",
                        "El colibrí, diminuto y colorido, es conocido por su vuelo ágil y batir rápido de alas. Se alimenta principalmente de néctar con su pico largo y delgado." +
                        " Presente en hábitats tropicales, es un polinizador crucial para diversas plantas." +
                        " A pesar de su pequeño tamaño, el colibrí deslumbra con su belleza y contribuye al equilibrio ecológico. \n\n\n\n\n\n\n",R.raw.hummingbird),
        };

        View miCabecera = getLayoutInflater().inflate(R.layout.cabecera, null);
        TextView textoCabecera = miCabecera.findViewById(R.id.txtCabecera);
        textoCabecera.setText(" Animales Vertebrados: \n Aves");
        listaAve.addHeaderView(miCabecera);

        Adaptador miAdaptador = new Adaptador(this, datos);
        listaAve.setAdapter(miAdaptador);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}