package com.example.examentema7parte2jorgedcm.AdaptadorLista;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.examentema7parte2jorgedcm.R;

import java.util.ArrayList;

public class Adaptador extends BaseAdapter {

    private ArrayList<Datos> datos;
    private Context contexto;

    public Adaptador(Context contexto, ArrayList<Datos> datos){
        super();
        this.contexto = contexto;
        this.datos = datos;
    }

    @Override
    public View getView(int posicion, View view, ViewGroup parent){

        LayoutInflater mostrado = LayoutInflater.from(contexto);
        View elemento = mostrado.inflate(R.layout.elemento, parent, false);

        ImageView avatar = elemento.findViewById(R.id.avatar);
        avatar.setImageResource(datos.get(posicion).getPersonaje());

        TextView nombre = (TextView) elemento.findViewById(R.id.nombre);
        nombre.setText(datos.get(posicion).getNombre());

        TextView telefono = (TextView) elemento.findViewById(R.id.telefono);
        telefono.setText(datos.get(posicion).getTelefono());

        return elemento;
    }

    @Override
    public int getCount(){
        return datos.size();
    }

    @Override
    public Datos getItem(int posicion){return datos.get(posicion);}

    @Override
    public long getItemId(int posicion){
        return posicion;
    }
}
