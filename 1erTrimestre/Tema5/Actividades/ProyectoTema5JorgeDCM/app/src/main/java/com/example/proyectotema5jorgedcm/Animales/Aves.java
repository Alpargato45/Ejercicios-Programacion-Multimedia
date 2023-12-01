package com.example.proyectotema5jorgedcm.Animales;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import androidx.appcompat.widget.Toolbar;

import com.example.proyectotema5jorgedcm.Adaptador.Adaptador;
import com.example.proyectotema5jorgedcm.Adaptador.Datos;
import com.example.proyectotema5jorgedcm.R;
import com.example.proyectotema5jorgedcm.menuBase;

public class Aves extends menuBase {

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
                       " Su presencia se extiende por diversos hábitats, y destacan por su elegancia y adaptabilidad.",1),
        };

        View miCabecera = getLayoutInflater().inflate(R.layout.cabecera, null);
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