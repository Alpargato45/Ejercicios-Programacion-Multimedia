package com.example.proyectotema5jorgedcm.Animales;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.example.proyectotema5jorgedcm.Adaptador.Adaptador;
import com.example.proyectotema5jorgedcm.Adaptador.Datos;
import com.example.proyectotema5jorgedcm.R;
import com.example.proyectotema5jorgedcm.Herencias.MenuBase;

public class Artropodo extends MenuBase {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atropodo);
        final ListView listaArtropodo = findViewById(R.id.listViewArtropodo);
        Toolbar toolbar = findViewById(R.id.toolbarArtropodo);
        setSupportActionBar(toolbar);

        Datos[] datos = new Datos[]{
                new Datos(R.drawable.cigarra,"Cigarra",
                        "La cigarra es un insecto conocido por su canto estridente en verano. Tiene una vida subterránea prolongada antes de emerger para reproducirse." +
                        " Su canto es exclusivo de los machos, y se utiliza para atraer a las hembras. " +
                        "Las cigarras son comunes en climas cálidos y contribuyen al ciclo natural como parte importante de la cadena alimentaria.",R.raw.cicada),
                new Datos(R.drawable.grillo,"Grillo",
                        "\n" +
                        "El grillo, insecto saltador, destaca por su canto nocturno producido por las alas de los machos." +
                        " Común en varios hábitats, su chirrido es característico. Los grillos contribuyen a la descomposición de materia orgánica y son conocidos por su capacidad para saltar." +
                        " Su sonido y agilidad son parte de su adaptabilidad en el ecosistema. \n\n\n\n\n\n\n",R.raw.cricket),
        };

        View miCabecera = getLayoutInflater().inflate(R.layout.cabecera, null);
        TextView textoCabecera = miCabecera.findViewById(R.id.txtCabecera);
        textoCabecera.setText(" Animales Invertebrados: \n Artrópodos");
        listaArtropodo.addHeaderView(miCabecera);

        Adaptador miAdaptador = new Adaptador(this, datos);
        listaArtropodo.setAdapter(miAdaptador);
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