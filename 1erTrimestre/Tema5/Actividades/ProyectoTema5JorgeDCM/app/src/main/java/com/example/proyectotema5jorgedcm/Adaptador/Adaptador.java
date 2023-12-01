package com.example.proyectotema5jorgedcm.Adaptador;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.proyectotema5jorgedcm.R;

public class Adaptador extends ArrayAdapter<Datos> {

    private Datos[] datos;
    private Context context;

    public Adaptador(Context context, Datos[] datos) {
        super(context, R.layout.elemento,datos);
        this.datos = datos;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater mostrado = LayoutInflater.from(getContext());
        View elemento = mostrado.inflate(R.layout.elemento,parent,false);

        TextView nombreAnimal = elemento.findViewById(R.id.txtNombre);
        nombreAnimal.setText(datos[position].getTitulo());

        TextView descripcion = elemento.findViewById(R.id.txtDescripcion);
        descripcion.setText(datos[position].getDescripcion());

        ImageView imagen = elemento.findViewById(R.id.imagen);
        imagen.setImageResource(datos[position].getImagen());


        final ImageButton sonido = elemento.findViewById(R.id.btnSonido);

        sonido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlayer sonidoAnimal = MediaPlayer.create(context,datos[position].getAudio());
                sonidoAnimal.start();
            }
        });

        return elemento;
    }
}
