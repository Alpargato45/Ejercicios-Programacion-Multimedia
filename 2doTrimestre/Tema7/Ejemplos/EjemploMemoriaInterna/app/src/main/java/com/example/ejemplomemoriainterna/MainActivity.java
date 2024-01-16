package com.example.ejemplomemoriainterna;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Escribo en memoria interna del dispositivo

        try {
            OutputStreamWriter miFichero = new OutputStreamWriter(openFileOutput("fichero.txt",MODE_PRIVATE));
            miFichero.write("Texto de Prueba");
            miFichero.close();
        }catch (Exception e){
            Log.e("Fichero","Error al escribir en memoria Interna");
        }

        //Recupero la información de memoria interna

        try {
            BufferedReader miFichero = new BufferedReader(new InputStreamReader(openFileInput("fichero.txt")));
            String texto = miFichero.readLine();
            miFichero.close();
            Toast.makeText(this, texto, Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            Log.e("Fichero","Error al leer en memoria Interna");
        }
    }
}