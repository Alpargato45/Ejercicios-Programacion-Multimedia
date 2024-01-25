package com.example.tema7ejercicio5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    private boolean sdDisponible;
    private boolean sdAccesoEscritura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);

        final EditText editText = findViewById(R.id.etTexto);
        final TextView textoRecuperado = findViewById(R.id.textoRecuperado);
        final Button btnGuardar = findViewById(R.id.btnGuardar);
        final Button btnRecuperar = findViewById(R.id.btnRecuperar);

        sdDisponible = false;
        sdAccesoEscritura = false;

        String estado = Environment.getExternalStorageState();

        if(estado.equals(Environment.MEDIA_MOUNTED)) {
            sdDisponible = true;
            sdAccesoEscritura = true;
        }else if (estado.equals(Environment.MEDIA_MOUNTED_READ_ONLY)) {
            sdDisponible = true;
        }

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sdDisponible && sdAccesoEscritura) {
                    try {
                        File ruta_sd = Environment.getExternalStorageDirectory();
                        File f = new File(ruta_sd.getAbsolutePath(), "prueba_sd.txt");

                        OutputStreamWriter fout = new OutputStreamWriter(new FileOutputStream(f));
                        fout.write(editText.getText().toString());
                        fout.close();
                    }catch (Exception e) {
                        Log.e("Ficheros","Error al escribir en la tarjeta");
                    }
                }
            }
        });

        btnRecuperar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sdDisponible) {
                    try {
                        File ruta_sd = Environment.getExternalStorageDirectory();
                        File f = new File(ruta_sd.getAbsolutePath(), "prueba_sd.txt");

                        BufferedReader fin = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
                        String texto = fin.readLine();
                        textoRecuperado.setText(texto);
                        fin.close();
                    }catch (Exception e) {
                        Log.e("Ficheros","Error al leer en la tarjeta");
                    }
                }
            }
        });
    }
}