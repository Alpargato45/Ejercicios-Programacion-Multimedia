package com.example.pruebaexamentema3jorgedcm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class Actividad2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
}