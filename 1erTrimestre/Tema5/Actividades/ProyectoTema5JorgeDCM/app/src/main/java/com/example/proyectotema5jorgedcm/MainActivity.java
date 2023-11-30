package com.example.proyectotema5jorgedcm;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
        final Button btnNoSesion = findViewById(R.id.btnAbrirSinSesion);
        final Button btnSesion = findViewById(R.id.btnInicioSesion);
        final Button btnRegistro = findViewById(R.id.btnRegistrarse);
        final Button btnSalir = findViewById(R.id.btnSalir);
        final ProgressBar progreso = findViewById(R.id.progreso);

        final Handler handler = new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                imagen.setVisibility(View.VISIBLE);
                btnNoSesion.setVisibility(View.VISIBLE);
                btnSesion.setVisibility(View.VISIBLE);
                btnRegistro.setVisibility(View.VISIBLE);
                btnSalir.setVisibility(View.VISIBLE);
                progreso.setVisibility(View.GONE);
            }
        },2000);

        btnNoSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,activityInicio.class);
                startActivity(intent);
            }
        });

        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}