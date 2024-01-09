package com.example.ejemplopreferenciascompartidas2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);

        final Button guardar = findViewById(R.id.btnGuardar);
        final Button cargar = findViewById(R.id.btnCargar);
        final Button borrar = findViewById(R.id.btnBorrar);
        final EditText etNombre = findViewById(R.id.etNombre);
        final EditText etCorreo = findViewById(R.id.etCorreo);

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Obtengo la referencia de la colección
                SharedPreferences pref = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);

                //Guardo los valores
                SharedPreferences.Editor editor = pref.edit();
                editor.putString("nombre",etNombre.getText().toString());
                editor.putString("correo",etCorreo.getText().toString());
                editor.commit();
            }
        });

        cargar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Obtengo la preferencia de la preferencia
                SharedPreferences pref = getSharedPreferences("MisPreferencias" ,Context.MODE_PRIVATE);

                String nombre = pref.getString("nombre","");
                String correo = pref.getString("correo","");

                etNombre.setText(nombre);
                etCorreo.setText(correo);
            }
        });

        borrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etNombre.setText("");
                etCorreo.setText("");
            }
        });

    }
}