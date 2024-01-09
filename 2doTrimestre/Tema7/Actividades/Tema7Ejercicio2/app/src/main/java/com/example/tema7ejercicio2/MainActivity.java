package com.example.tema7ejercicio2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);

        final Button btnDefinir = findViewById(R.id.btnDefinir);
        final Button btnRecuperar = findViewById(R.id.btnRecuperar);

        btnDefinir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, OpcionesActivity.class));
            }
        });

        btnRecuperar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);

                Log.i("Preferencias", "opcion 1: " + pref.getBoolean("opcion1", false));
                Log.i("Preferencias", "opcion 2: " + pref.getString("opcion2", ""));
                Log.i("Preferencias", "opcion 3: " + pref.getString("opcion3", ""));

                Toast.makeText(MainActivity.this, "Recuperado Correctamente en el Log", Toast.LENGTH_SHORT).show();
            }
        });
    }
}