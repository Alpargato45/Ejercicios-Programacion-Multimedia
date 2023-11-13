package com.example.trucootrato;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SegundaVentana extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout2);

        final TextView fantasmas = findViewById(R.id.txtFantasmas);
        final TextView calabazas = findViewById(R.id.txtCalabazas);
        Intent intent = new Intent();

        fantasmas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("textoElegido","fantasma");
                setResult(RESULT_OK,intent);
                finish();
            }
        });

        calabazas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("textoElegido","calabaza");
                setResult(RESULT_OK,intent);
                finish();
            }
        });

    }
}