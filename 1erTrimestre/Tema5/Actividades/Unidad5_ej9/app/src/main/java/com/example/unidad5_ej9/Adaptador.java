package com.example.unidad5_ej9;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;


import java.util.ArrayList;

public class Adaptador extends ArrayAdapter {

    private ArrayList<Datos> datos;

    private Context contexto;


    public Adaptador(Context contexto, ArrayList<Datos> datos) {
        super(contexto, R.layout.elemento, datos);
        this.contexto = contexto;
        this.datos = datos;
    }

    @NonNull
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater mostrado = LayoutInflater.from(contexto);
        View elemento = mostrado.inflate(R.layout.elemento, parent, false);

        ImageView imagen = elemento.findViewById(R.id.miImagen);
        imagen.setImageResource(datos.get(position).getImagen());

        TextView texto = elemento.findViewById(R.id.miTexto);
        texto.setText(datos.get(position).getTexto());

        CheckBox cb = elemento.findViewById(R.id.miCB);
        cb.setChecked(datos.get(position).isSelected());

        cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    datos.get(position).setCheckbox(true);
                } else {
                    datos.get(position).setCheckbox(false);
                }
            }
        });

        return elemento;
    }


}
