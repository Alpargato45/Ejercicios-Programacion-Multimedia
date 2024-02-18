package com.example.apimusica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;

import com.example.apimusica.AllJSON.GestionJson;

import java.io.IOException;
import java.util.Date;

public class ActivityCancion extends AppCompatActivity {

    private final Handler handler = new Handler(Looper.getMainLooper());
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_cancion);

        final TextView txtDuracion = findViewById(R.id.txtDuracion);
        final ImageView img = findViewById(R.id.fotoCover);
        final TextView txtTitulo = findViewById(R.id.txtTituloCancion);
        final TextView txtFecha = findViewById(R.id.txtFechaSalida);
        final Button btnEscucha = findViewById(R.id.btnEscucha);
        final Button btnCantante = findViewById(R.id.btnCantante);
        final TextView txtCantante = findViewById(R.id.txtCantante);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String cancion = conseguirCancion();

                    GestionJson gestion = new GestionJson(cancion);
                    String jsonCompletoData = gestion.llamarApi("https://api.deezer.com/search?q=");

                    if(jsonCompletoData != null) {
                        final int duracion = gestion.obtenerduracionCancion(jsonCompletoData);
                        final String cover = gestion.obtenercoverAlbum(jsonCompletoData);
                        final String titulo = gestion.obtenertituloCancion(jsonCompletoData);
                        final String link = gestion.obtenerLinkCancion(jsonCompletoData);
                        final String fechaCreacion = conseguirFechaCreacion(gestion.obtenerIdCancion(jsonCompletoData),cancion);
                        final String nombreCantante = gestion.obtenerNombreCantante(jsonCompletoData);

                        btnEscucha.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                abrirPagina(link);
                            }
                        });

                        btnCantante.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                abrirArtista(gestion.obtenerNombreCantante(jsonCompletoData));
                            }
                        });

                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                txtDuracion.setText(txtDuracion.getText() + conseguirTiempo(duracion));
                                Picasso.get().load(cover).into(img);
                                txtTitulo.setText(titulo);
                                txtFecha.setText(txtFecha.getText() + fechaCreacion);
                                txtCantante.setText(txtCantante.getText() + nombreCantante);
                                btnCantante.setText(btnCantante.getText() + nombreCantante);
                            }
                        });
                    }else {
                        txtDuracion.setText("");
                        Picasso.get().load(R.drawable.imagen_placeholder).into(img);
                        txtTitulo.setText("Error de conexión a la api");
                        txtFecha.setText("");
                    }
                } catch (final IOException e) {
                    e.printStackTrace();
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            txtDuracion.setText("");
                            Picasso.get().load(R.drawable.imagen_placeholder).into(img);
                            txtTitulo.setText("Error de red");
                            txtFecha.setText("");
                        }
                    });
                }
            }
        }).start();
    }

    private String conseguirTiempo(int duracion) {
        String tiempo;
        int seg = duracion % 60;
        String segStr = (seg < 10) ? "0" + seg : String.valueOf(seg);
        tiempo = duracion / 60 + ":" + segStr;
        return tiempo;
    }

    private String conseguirCancion() {
        Bundle extras = getIntent().getExtras();
        String s = extras.getString("cancion");
        return s;
    }

    private void abrirPagina(String link){
        Intent intent = new Intent(Intent.ACTION_VIEW,
                Uri.parse(link));
        startActivity(intent);
    }

    private void abrirArtista(String artista) {
        Intent intent = new Intent(ActivityCancion.this, ActivityArtista.class);
        intent.putExtra("artista",artista);
        startActivity(intent);
    }

    private String conseguirFechaCreacion(long id,String cancion) throws IOException {
        GestionJson gestionTrack = new GestionJson(id+"");
        String jsonCompletoTrack = gestionTrack.llamarApi("https://api.deezer.com/track/");
        Log.i("prueba",jsonCompletoTrack);

        return gestionTrack.obtenerFechaCancion(jsonCompletoTrack);
    }
}