package com.example.apimusica;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.apimusica.AllJSON.GestionJson;
import com.example.apimusica.R;
import com.squareup.picasso.Picasso;

import java.io.IOException;

public class ActivityArtista extends AppCompatActivity {
    private final Handler handler = new Handler(Looper.getMainLooper());
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_artista);

        final TextView txtNombreArtista = findViewById(R.id.txtNombreCantante);
        final ImageView img = findViewById(R.id.imgArtista);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String artista = conseguirArtista();

                    GestionJson gestion = new GestionJson(artista);
                    String jsonCompletoData = gestion.llamarApi("https://api.deezer.com/search/artist?q=");

                    if(jsonCompletoData != null) {

                        final String nombre = gestion.obtenerNombreCantanteDesdeArtista(jsonCompletoData);
                        final String foto = gestion.obtenerFotoArtista(jsonCompletoData);

                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                txtNombreArtista.setText(nombre);
                                Picasso.get().load(foto).into(img);

                                if(txtNombreArtista.getText().equals("")) {
                                    txtNombreArtista.setText("No se encontró el cantante");
                                }
                            }
                        });
                    }else {
                        txtNombreArtista.setText("Error de conexión a la api");
                    }
                } catch (final IOException e) {
                    e.printStackTrace();
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            txtNombreArtista.setText("Error de red");
                        }
                    });
                }
            }
        }).start();
    }

    private String conseguirArtista() {
        Bundle extras = getIntent().getExtras();
        String s = extras.getString("artista");
        return s;
    }
}