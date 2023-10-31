package com.example.prueba;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        actividad1();
    }

    public void actividad1() {
        setContentView(R.layout.main);

        final EditText editTextNombre = findViewById(R.id.editTextNombre);
        final EditText editTextContraseña = findViewById(R.id.editTextContraseña);
        final Button botonAcceso = findViewById(R.id.btnAcceso);
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                editTextNombre.setVisibility(View.VISIBLE);
                editTextContraseña.setVisibility(View.VISIBLE);
                botonAcceso.setVisibility(View.VISIBLE);
            }
        },3000);


        botonAcceso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!editTextNombre.getText().toString().equals("") && !editTextContraseña.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "Hola " + editTextNombre.getText() + ". Accediendo a la app", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this, "Introduce usuario y clave", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void actividad2() {
        setContentView(R.layout.activity2);

        final Button btnPeso = findViewById(R.id.btnPeso);
        final Button btnFuerte = findViewById(R.id.btnFuerte);
        final Button btnForma = findViewById(R.id.btnForma);
        final Button btnSiguiente = findViewById(R.id.btnSiguiente);

        btnPeso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnPeso.setBackgroundColor(Color.parseColor("#F3E6F8"));
            }
        });
        btnFuerte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnFuerte.setBackgroundColor(Color.parseColor("#F3E6F8"));
            }
        });
        btnForma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnForma.setBackgroundColor(Color.parseColor("#F3E6F8"));
            }
        });
        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Accediendo a la siguiente pantalla", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void actividad3() {
        setContentView(R.layout.activity3);

        final Spinner spinner = findViewById(R.id.spinnerDia);
        final TextView txtSpinner = findViewById(R.id.txtSpinner);
        String[] valores = {"Dia 1", "Dia 2", "Dia 3", "Dia 4", "Dia 5", "Dia 6", "Dia 7"};

        spinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,valores));

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                txtSpinner.setText(spinner.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}