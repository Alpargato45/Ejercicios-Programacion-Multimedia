package com.example.tema7ejercicio6;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

public class Adaptador extends ArrayAdapter<Datos> {

    private Datos[] datos;

    public Adaptador(@NonNull Context context, Datos[] datos) {
        super(context, R.layout.elemento,datos);
        this.datos = datos;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView==null){
            convertView =
                    LayoutInflater.from(getContext()).inflate(R.layout.elemento,parent,false);
        }
        ImageView icono = convertView.findViewById(R.id.imagen);
        Datos elemento = getItem(position);
        if (elemento!=null){
            icono.setImageResource(elemento.getImagen());
        }
        return convertView;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull
    ViewGroup parent) {
        if (convertView==null){
            convertView =
                    LayoutInflater.from(getContext()).inflate(R.layout.elemento,parent,false);
        }
        ImageView icono = convertView.findViewById(R.id.imagen);
        Datos elemento = getItem(position);
        if (elemento!=null){
            icono.setImageResource(elemento.getImagen());
        }
        return convertView;
    }
}