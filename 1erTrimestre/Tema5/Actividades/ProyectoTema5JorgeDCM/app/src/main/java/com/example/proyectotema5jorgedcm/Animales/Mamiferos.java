package com.example.proyectotema5jorgedcm.Animales;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;


import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.proyectotema5jorgedcm.Adaptador.Adaptador;
import com.example.proyectotema5jorgedcm.Adaptador.Datos;
import com.example.proyectotema5jorgedcm.Herencias.MenuBase;
import com.example.proyectotema5jorgedcm.R;

public class Mamiferos extends MenuBase {

    private ListView listaMamiferos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mamiferos);

        listaMamiferos = findViewById(R.id.listViewMamiferos);
        Toolbar toolbar = findViewById(R.id.toolbarMamiferos);
        setSupportActionBar(toolbar);

        Datos[] datos = new Datos[]{
                new Datos(R.drawable.leon, "León", "los leones son grandes felinos sociales con distintivas melenas en los machos. " +
                        "Viven en manadas en la sabana africana, cazando presas como ñus y cebras. Su rugido es característico, " +
                        "y son símbolos de fuerza y nobleza.", R.raw.lion_roar),
                new Datos(R.drawable.mono, "Mono", "Los monos son primates ágiles con colas prensiles, " +
                        "variando en tamaño desde pequeños titíes hasta grandes simios. Son omnívoros, " +
                        "viven en grupos sociales y exhiben comportamientos juguetones.", R.raw.monkey),
                new Datos(R.drawable.canguro, "Canguro", "Los canguros, marsupiales australianos, destacan por sus saltos largos " +
                        "gracias a sus poderosas patas traseras. Las hembras llevan a sus crías en una bolsa marsupial. " +
                        "Estos herbívoros desempeñan un papel importante en los ecosistemas locales.", R.raw.kangaroo),
                new Datos(R.drawable.leopardo, "Leopardo",
                        "Los leopardos son felinos ágiles con manchas distintivas, nativos de África y Asia. " +
                        "Son solitarios y nocturnos, con habilidades para trepar árboles. Su pelaje manchado les brinda camuflaje en su entorno. " +
                        "Como carnívoros, desempeñan un papel crucial en el equilibrio de las poblaciones de presas.", R.raw.leopard),
                new Datos(R.drawable.zorro,"Zorro","\n" +
                        "Los zorros son mamíferos carnívoros con pelajes espesos y colas esponjosas. Se adaptan a diversos hábitats, desde bosques hasta áreas urbanas. " +
                        "Cazadores nocturnos, se alimentan de pequeños mamíferos y aves. " +
                        "Su aguda inteligencia y adaptabilidad son clave para su supervivencia. \n\n\n\n\n\n\n",R.raw.fox)
        };

        View miCabecera = getLayoutInflater().inflate(R.layout.cabecera, null);
        listaMamiferos.addHeaderView(miCabecera);

        Adaptador miAdaptador = new Adaptador(this, datos);
        listaMamiferos.setAdapter(miAdaptador);
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