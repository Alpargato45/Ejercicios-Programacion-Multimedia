package com.example.tema7ejercicio1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);

        final Button guardar = findViewById(R.id.btnGuardar);
        final Button recuperar = findViewById(R.id.btnRecuperar);
        final EditText etPrimero = findViewById(R.id.etPrimero);
        final EditText etSegundo = findViewById(R.id.etSegundo);
        final TextView textoPrimero = findViewById(R.id.textViewPrimero);
        final TextView textoSegundo = findViewById(R.id.textViewSegundo);

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences pref = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();
                editor.putString("primerTexto", etPrimero.getText().toString());
                editor.putString("segundoTexto", etSegundo.getText().toString());
                editor.commit();
                Toast.makeText(MainActivity.this, "Datos Guardados Correctamente", Toast.LENGTH_SHORT).show();
            }
        });

        recuperar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences pref = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);

                String primero = pref.getString("primerTexto","");
                String segundo = pref.getString("segundoTexto","");

                textoPrimero.setText(primero);
                textoSegundo.setText(segundo);
                Toast.makeText(MainActivity.this, "Datos Recuperados Correctamente", Toast.LENGTH_SHORT).show();
            }
        });
    }
}