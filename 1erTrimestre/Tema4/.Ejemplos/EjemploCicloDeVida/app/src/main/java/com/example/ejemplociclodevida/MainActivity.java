package com.example.ejemplociclodevida;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    public void addContentView(View view, ViewGroup.LayoutParams params) {
        super.addContentView(view, params);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);


    }
    //Definimos el método callback onStart de la actividad
    @Override
    protected void onStart() {
        super.onStart();

        //Aqui deberíamos leer los datos de la última sesión
        //Para continuar la actividad donde la dejó el usuario
        Toast.makeText(this, "Se ejecuta el método onStart", Toast.LENGTH_SHORT).show();
    }

    //Definimos el método callback onResume de la actividad
    @Override
    protected void onResume() {
        super.onResume();

        Toast.makeText(this, "Se ejecuta el método onResume", Toast.LENGTH_SHORT).show();
    }

    //Definimos el método callback onPause de la actividad
    @Override
    protected void onPause() {
        super.onPause();

        //Aquí deberíamos guardar la información para la siguiente sesión
        Toast.makeText(this, "Se ejecuta el método onPause", Toast.LENGTH_SHORT).show();
    }

    //Definimos el método callback onStop de la actividad
    @Override
    protected void onStop() {
        super.onStop();

        Toast.makeText(this, "Se ejecuta el método onStop", Toast.LENGTH_SHORT).show();
    }

    //Definimos el método callback onRestart de la actividad
    @Override
    protected void onRestart() {
        super.onRestart();

        Toast.makeText(this, "Se ejecuta el método onRestart", Toast.LENGTH_SHORT).show();
    }

    //Definimos el método callback ondestroy de la actividad
    @Override
    protected void onDestroy() {
        super.onDestroy();

        Toast.makeText(this, "Se ejecuta el método onDestroy", Toast.LENGTH_SHORT).show();
    }

}