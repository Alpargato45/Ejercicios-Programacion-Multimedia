package com.example.ejercicio10tema3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);

        final Button miBoton = findViewById(R.id.BtnReset);
        final EditText textoNombre = findViewById(R.id.editTextNombre);
        final EditText textoClave = findViewById(R.id.editTextClave);

        miBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                textoNombre.setText("");
                textoClave.setText("");

            }
        });





    }
}