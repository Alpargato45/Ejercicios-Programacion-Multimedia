package com.example.pruebaexamentema3jorgedcm;

import androidx.appcompat.app.AppCompatActivity;

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
        layout1();





    }

    private void layout1(){
        setContentView(R.layout.primer_layout);
        final Button btnLayout2 = findViewById(R.id.btnLayout2);
        final Button btnLayout3 = findViewById(R.id.btnLayout3);
        final Switch cambioFondo = findViewById(R.id.switchCambioFondo);
        RelativeLayout padre = findViewById(R.id.layoutPadre);

        btnLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout2();
            }
        });

        btnLayout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout3();
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
    private void layout2(){
        setContentView(R.layout.segundo_layout);
        final CheckBox CheckBoxRecordatorio = findViewById(R.id.CheckBoxRecordatorio);
        final Button botonAceptar = findViewById(R.id.btnAceptar);
        final TextView textoFinal = findViewById(R.id.textoFinal);
        final EditText editNombre = findViewById(R.id.editNombre);
        final EditText editFecha = findViewById(R.id.editFecha);

        botonAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String texto;
                String nombre = editNombre.getText().toString();
                String fecha = editFecha.getText().toString();

                if (!nombre.isEmpty() && !fecha.isEmpty()) {
                    texto = "¡Hola " + nombre + "! Has nacido el " + fecha + ".";
                    if (CheckBoxRecordatorio.isChecked()) {
                        texto += " Se ha creado un recordatorio.";
                    }
                } else if (nombre.isEmpty() && !fecha.isEmpty()) {
                    texto = "ERROR. No has puesto el Nombre.";
                } else if (!nombre.isEmpty() && fecha.isEmpty()) {
                    texto = "ERROR. No has puesto la Fecha.";
                } else {
                    texto = "ERROR. No has puesto el Nombre ni la Fecha.";
                }
                textoFinal.setText(texto);
            }
        });


    }
    private void layout3(){
        setContentView(R.layout.tercer_layout);

        final RatingBar ratingBar = findViewById(R.id.ratingBar);
        final ImageView imagenNota = (ImageView) findViewById(R.id.imagenRating);

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                if(rating == 1) {
                    imagenNota.setImageResource(R.drawable.unaestrella);
                }else if(rating == 2) {
                    imagenNota.setImageResource(R.drawable.dosestrellas);
                }else if(rating == 3) {
                    imagenNota.setImageResource(R.drawable.tresestrellas);
                }else if(rating == 4) {
                    imagenNota.setImageResource(R.drawable.cuatroestrellas);
                }else if(rating == 5) {
                    imagenNota.setImageResource(R.drawable.cincoestrellas);
                }
            }
        });

    }

}