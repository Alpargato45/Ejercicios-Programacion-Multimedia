package com.example.pruebaexamentema3jorgedcm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.primer_layout);
        final Button btnLayout2 = findViewById(R.id.btnLayout2);
        final Button btnLayout3 = findViewById(R.id.btnLayout3);
        final Switch cambioFondo = findViewById(R.id.switchCambioFondo);
        RelativeLayout padre = findViewById(R.id.layoutPadre);

        btnLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentPantalla2 = new Intent(MainActivity.this, Actividad2.class);
                startActivity(intentPantalla2);
            }
        });

        btnLayout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentPantalla3 = new Intent(MainActivity.this, Actividad3.class);
                startActivity(intentPantalla3);
            }
        });

        cambioFondo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    padre.setBackgroundColor(Color.parseColor("#000000"));
                } else {
                    padre.setBackgroundColor(Color.parseColor("#ffffff"));
                }
            }
        });
    }
}