package com.example.examentema3jorgedcm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Handler handler = new Handler();
        final EditText usuario = findViewById(R.id.editTextUsuario);
        final EditText contraseña = findViewById(R.id.editTextContraseña);
        final Button botonAcceso = findViewById(R.id.btnAcceso);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                usuario.setVisibility(View.VISIBLE);
                contraseña.setVisibility(View.VISIBLE);
                botonAcceso.setVisibility(View.VISIBLE);
            }
        },3000);

        botonAcceso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!usuario.getText().toString().equals("") && !contraseña.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "Hola " + usuario.getText().toString() + ". Accediendo a la app", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this,Actividad2.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(MainActivity.this, "Introduce Usuario y clave", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}