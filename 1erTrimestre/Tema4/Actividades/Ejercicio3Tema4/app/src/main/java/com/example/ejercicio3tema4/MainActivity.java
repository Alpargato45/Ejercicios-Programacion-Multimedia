package com.example.ejercicio3tema4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);

        final Button btnMandarMensaje = findViewById(R.id.btnMandarMensaje);
        final Button btnAbrirPaginaWeb = findViewById(R.id.btnAbrirPaginaWeb);
        final Button btnLlamarPorTelefono = findViewById(R.id.btnLlamarPorTelefono);
        final Button btnAbrirMapa = findViewById(R.id.btnAbrirMapa);
        final Button btnTomarFoto = findViewById(R.id.btnTomarFoto);
        final Button btnMandarCorreo = findViewById(R.id.btnMandarCorreo);
        final Button btnStreetView = findViewById(R.id.btnStreetView);

        btnMandarMensaje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mandar_mensaje(v);
            }
        });
        btnAbrirPaginaWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirPagina(v);
            }
        });
        btnLlamarPorTelefono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                llamarTelefono(v);
            }
        });
        btnAbrirMapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verMapa(v);
            }
        });
        btnTomarFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tomarFoto(v);
            }
        });
        btnMandarCorreo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mandarCorreo(v);
            }
        });
    }
    public void mandar_mensaje(View view){
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT,"¿A qué hora quedamos?");
        startActivity(intent);
    }
    public void abrirPagina(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("http://www.iesbelen.org/"));
        startActivity(intent);
    }
    public void llamarTelefono(View view){
        Intent intent = new
                Intent(Intent.ACTION_CALL,Uri.parse("tel:000000000"));
        startActivity(intent);
    }
    public void verMapa(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("geo:36.695804,-4.457127?z=18"));
        startActivity(intent);
    }
    public void tomarFoto(View view){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivity(intent);
    }
    public void mandarCorreo(View view){
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT,"asunto");
        intent.putExtra(Intent.EXTRA_TEXT,"texto del correo");
        intent.putExtra(Intent.EXTRA_EMAIL, new
                String[]{"rbaebar@g.educaand.es"});
        startActivity(intent);
    }
}