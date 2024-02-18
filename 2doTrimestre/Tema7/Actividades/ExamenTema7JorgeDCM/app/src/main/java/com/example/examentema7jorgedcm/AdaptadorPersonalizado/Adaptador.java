package com.example.examentema7jorgedcm.AdaptadorPersonalizado;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.examentema7jorgedcm.R;

import java.util.ArrayList;

public class Adaptador extends ArrayAdapter<Datos> {

    private  ArrayList<Datos> datos;

    public Adaptador(@NonNull Context context, ArrayList<Datos> datos) {
        super(context, R.layout.elemento,datos);
        this.datos = datos;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater mostrado = LayoutInflater.from(getContext());
        View elemento = mostrado.inflate(R.layout.elemento,parent,false);

        TextView textoNombre = (TextView) elemento.findViewById(R.id.txtNombre);
        textoNombre.setText(datos.get(position).getNombre());

        ImageView imagen = (ImageView) elemento.findViewById(R.id.imagen);
        imagen.setImageResource(datos.get(position).getFoto());

        return elemento;
    }
}