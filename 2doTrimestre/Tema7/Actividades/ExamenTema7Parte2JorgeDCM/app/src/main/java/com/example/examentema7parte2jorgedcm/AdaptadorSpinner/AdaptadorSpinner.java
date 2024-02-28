package com.example.examentema7parte2jorgedcm.AdaptadorSpinner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.examentema7parte2jorgedcm.R;

public class AdaptadorSpinner extends ArrayAdapter<DatosSpinner> {

    private DatosSpinner[] datos;

    public AdaptadorSpinner(@NonNull Context context, DatosSpinner[] datos) {
        super(context, R.layout.elemento_imagen, datos);
        this.datos = datos;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView==null){
            convertView =
                    LayoutInflater.from(getContext()).inflate(R.layout.elemento_imagen,parent,false);
        }
        ImageView icono = convertView.findViewById(R.id.imagen);
        DatosSpinner elemento = getItem(position);
        if (elemento!=null){
            icono.setImageResource(elemento.getImagen());
        }
        return convertView;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull
    ViewGroup parent) {
        if (convertView==null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.elemento_imagen,parent,false);
        }
        ImageView icono = convertView.findViewById(R.id.imagen);
        DatosSpinner elemento = getItem(position);
        if (elemento!=null){
            icono.setImageResource(elemento.getImagen());
        }
        return convertView;
    }
}
