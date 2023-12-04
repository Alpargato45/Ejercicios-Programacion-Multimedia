package com.example.proyectotema5jorgedcm;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView imagen = findViewById(R.id.imagenAnimales);
        final Button btnAbrir = findViewById(R.id.btnAbrirAplicacion);
        final Button btnNational = findViewById(R.id.btnNational);
        final Button btnCorreo = findViewById(R.id.btnCorreo);
        final Button btnSalir = findViewById(R.id.btnSalir);
        final ProgressBar progreso = findViewById(R.id.progreso);

        final Handler handler = new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                imagen.setVisibility(View.VISIBLE);
                btnAbrir.setVisibility(View.VISIBLE);
                btnNational.setVisibility(View.VISIBLE);
                btnCorreo.setVisibility(View.VISIBLE);
                btnSalir.setVisibility(View.VISIBLE);
                progreso.setVisibility(View.GONE);
            }
        },2000);

        btnAbrir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,activityInicio.class);
                startActivity(intent);
            }
        });

        btnNational.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirNational(v);
            }
        });

        btnCorreo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mandarCorreo(v);
            }
        });

        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void abrirNational(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("https://www.nationalgeographic.com.es/mundo-animal"));
        startActivity(intent);
    }

    public void mandarCorreo(View view){
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT,"Nota Proyecto Android");
        intent.putExtra(Intent.EXTRA_TEXT,"Felicidades Jorge, tienes un 10.");
        intent.putExtra(Intent.EXTRA_EMAIL, new
                String[]{"jcidmor0311@g.edcuaand.es"});
        startActivity(intent);
    }
}