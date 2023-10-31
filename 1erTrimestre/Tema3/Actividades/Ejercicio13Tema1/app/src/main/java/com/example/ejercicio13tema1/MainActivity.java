package com.example.ejercicio13tema1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);

        Spinner spinner = findViewById(R.id.Spinner);
        String[] valores = {"Prueba 1","Prueba 2","Prueba 3"};
        Switch mostrar = findViewById(R.id.Switch);
        SeekBar barra = findViewById(R.id.SeekBar);

        mostrar.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean pulsado) {
                if (pulsado) {
                    spinner.setVisibility(View.VISIBLE);
                }else {
                    spinner.setVisibility(View.GONE);
                }
            }
        });

        spinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,valores));

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                if(position == 1) {
                    barra.setVisibility(View.VISIBLE);
                }else {
                    barra.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                
            }
        });

        }

    }