package com.example.examentema3jorgedcm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Actividad2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);

        final Button btnPeso = findViewById(R.id.btnPeso);
        final Button btnFuerte = findViewById(R.id.btnFuerte);
        final Button btnForma = findViewById(R.id.btnForma);
        final Button btnSiguiente = findViewById(R.id.btnSiguiente);
        final int redCambio = 243;
        final int greenCambio = 230;
        final int blueCambio = 248;
        final int redBase = 247;
        final int greenBase = 193;
        final int blueBase = 234;

        btnPeso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnPeso.setBackgroundColor(Color.rgb(redCambio,greenCambio,blueCambio));
                btnForma.setBackgroundColor(Color.rgb(redBase,greenBase,blueBase));
                btnFuerte.setBackgroundColor(Color.rgb(redBase,greenBase,blueBase));
            }
        });

        btnFuerte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnFuerte.setBackgroundColor(Color.rgb(redCambio,greenCambio,blueCambio));
                btnPeso.setBackgroundColor(Color.rgb(redBase,greenBase,blueBase));
                btnForma.setBackgroundColor(Color.rgb(redBase,greenBase,blueBase));
            }
        });

        btnForma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnForma.setBackgroundColor(Color.rgb(redCambio,greenCambio,blueCambio));
                btnPeso.setBackgroundColor(Color.rgb(redBase,greenBase,blueBase));
                btnFuerte.setBackgroundColor(Color.rgb(redBase,greenBase,blueBase));
            }
        });

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Actividad2.this, "Accediendo a la siguiente pantalla", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Actividad2.this, Actividad3.class);
                startActivity(intent);
            }
        });
    }
}