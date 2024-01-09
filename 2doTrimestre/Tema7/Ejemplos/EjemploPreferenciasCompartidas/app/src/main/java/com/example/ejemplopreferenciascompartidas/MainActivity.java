package com.example.ejemplopreferenciascompartidas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);

        final Button guardar = findViewById(R.id.btnGuardar);
        final Button cargar = findViewById(R.id.btnCargar);

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Obtengo la referencia de la colección de preferencias (archivo xml)
                //Donde tengo o voy a guardar las preferencias
                SharedPreferences pref = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);

                //Guardamos los valores
                SharedPreferences.Editor editor = pref.edit();
                editor.putString("nombre","Jorge");
                editor.putString("email","jorgedelcid2004@gmail.com");

                //Guardo los cambios
                editor.commit();
            }
        });

        cargar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Obtengo la referencia de la colección de preferencias
                //donde tengo los datos
                SharedPreferences pref = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);

                String nombre = pref.getString("nombre","");
                String email = pref.getString("email","");

                Log.i("Preferencias", "Nombre: " + nombre);
                Log.i("Preferencias", "Correo: " + email);
            }
        });

    }
}