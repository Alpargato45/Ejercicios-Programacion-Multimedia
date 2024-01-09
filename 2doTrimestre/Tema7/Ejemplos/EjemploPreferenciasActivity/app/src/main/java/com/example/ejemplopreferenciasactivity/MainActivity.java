package com.example.ejemplopreferenciasactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);

        final Button btnPreferencias = findViewById(R.id.btnPreferencias);
        final Button btnConsultar = findViewById(R.id.btnConsultar);

        btnPreferencias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, OpcionesActivity.class));
            }
        });

        btnConsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);

                Log.i("Preferencias", "opcion 1 " + pref.getBoolean("opcion1", false));
                Log.i("Preferencias", "opcion 2 " + pref.getString("opcion2", ""));
                Log.i("Preferencias", "opcion 3 " + pref.getString("opcion3", ""));
            }
        });
    }
}