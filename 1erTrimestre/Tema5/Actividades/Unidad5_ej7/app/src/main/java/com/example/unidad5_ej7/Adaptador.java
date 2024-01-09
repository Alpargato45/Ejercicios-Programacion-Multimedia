package com.example.unidad5_ej7;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Adaptador extends BaseAdapter {

    private ArrayList<Datos> datos;

    private Context contexto;


    public Adaptador(Context contexto, ArrayList<Datos> datos) {
        super();
        this.datos = datos;
        this.contexto = contexto;
    }

    @Override
    public int getCount() {
        return datos.size();
    }

    @Override
    public Object getItem(int position) {
        return datos.get(position);
    }

    @Override
    public long getItemId(int position) {

        // Devuelve la fila
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        LayoutInflater mostrado = LayoutInflater.from(contexto);
        View elemento = mostrado.inflate(R.layout.elemento, parent, false);

        ImageView imagen = elemento.findViewById(R.id.imagen);
        imagen.setImageResource(datos.get(position).getImagen());

        TextView texto1 = elemento.findViewById(R.id.miTexto1);
        texto1.setText(datos.get(position).getTexto1());


        TextView texto2 = elemento.findViewById(R.id.miTexto2);
        texto2.setText(datos.get(position).getTexto2());

        return elemento;
    }
}
