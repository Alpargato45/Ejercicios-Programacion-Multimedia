package com.example.tema7ejercicio4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);

        final Button btnGuardar = findViewById(R.id.btnGuardar);
        final  Button btnRecuperar = findViewById(R.id.btnRecuperar);
        final EditText editText = findViewById(R.id.etTexto);
        final TextView textoRecuperado = findViewById(R.id.textoRecuperado);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    OutputStreamWriter miFichero = new OutputStreamWriter(openFileOutput("fichero.txt",MODE_PRIVATE));
                    miFichero.write(editText.getText().toString());
                    miFichero.close();
                    Toast.makeText(MainActivity.this, "Texto Guardado", Toast.LENGTH_SHORT).show();
                }catch (Exception e) {
                    Log.e("Fichero","Error al escribir en memoria Interna");
                }
            }
        });

        btnRecuperar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    BufferedReader miFichero = new BufferedReader(new InputStreamReader(openFileInput("fichero.txt")));
                    String texto = miFichero.readLine();
                    miFichero.close();
                    textoRecuperado.setText(texto);
                }catch (Exception e) {
                    Log.e("Fichero","Error al leer en memoria Interna");
                }
            }
        });

    }
}