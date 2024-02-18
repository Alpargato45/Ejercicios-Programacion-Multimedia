package com.example.tema7ejercicio6;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private boolean sdDisponible = false;
    private boolean sdAccesoEscritura = false;
    private int imagenSeleccionada;
    private ArrayList<Integer> listaImagenes;
    private int contadorImagen;
    private Button btnAnterior;
    private Button btnSiguiente;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);

        final Button btnGuardar = findViewById(R.id.btnGuardar);
        final Button btnCargar = findViewById(R.id.btnCargar);
        final Button btnBorrar = findViewById(R.id.btnBorrar);
        btnAnterior = findViewById(R.id.btnAnterior);
        btnSiguiente = findViewById(R.id.btnSiguiente);
        final LinearLayout datosCarga = findViewById(R.id.linearCarga);
        final ImageView imagenCarga = findViewById(R.id.imgCargada);

        final Spinner spinner = findViewById(R.id.spinnerImagenes);
        Datos[] datos = new Datos[]{
                new Datos(R.drawable.batman),
                new Datos(R.drawable.capi),
                new Datos(R.drawable.deadpool),
                new Datos(R.drawable.furia),
                new Datos(R.drawable.hulk),
                new Datos(R.drawable.ironman),
                new Datos(R.drawable.lobezno),
                new Datos(R.drawable.spiderman),
                new Datos(R.drawable.thor),
                new Datos(R.drawable.wonderwoman),
        };

        Adaptador miAdaptador = new Adaptador(this,datos);
        spinner.setAdapter(miAdaptador);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ImageView imagen = findViewById(R.id.imagen);
                imagenSeleccionada = datos[position].getImagen();
                imagen.setImageResource(imagenSeleccionada);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {}});

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
                        datosCarga.setVisibility(View.INVISIBLE);
                        File ruta_sd = Environment.getExternalStorageDirectory();
                        File f = new File(ruta_sd.getAbsolutePath(), "imagenes.txt");
                        OutputStreamWriter fout = new OutputStreamWriter(new FileOutputStream(f));
                        fout.write(imagenSeleccionada + "\n");
                        fout.close();
                    }catch (Exception e) {
                        Log.e("Ficheros","Error al escribir en la tarjeta");
                    }
                }
            }
        });

        btnCargar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sdDisponible) {
                    try {
                        File ruta_sd = Environment.getExternalStorageDirectory();
                        File f = new File(ruta_sd.getAbsolutePath(), "imagenes.txt");

                        BufferedReader fin = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
                        listaImagenes = (ArrayList<Integer>) fin.lines();

                        if(listaImagenes != null) {
                            datosCarga.setVisibility(View.VISIBLE);
                            imagenCarga.setImageResource(listaImagenes.get(0));
                            comprobarBotones();
                            contadorImagen = 0;

                            btnAnterior.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    comprobarBotones();
                                    if (contadorImagen > 0) {
                                        contadorImagen--;
                                        imagenCarga.setImageResource(listaImagenes.get(contadorImagen));
                                    }
                                }
                            });

                            btnSiguiente.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    comprobarBotones();
                                    if (contadorImagen < listaImagenes.size()) {
                                        contadorImagen++;
                                        imagenCarga.setImageResource(listaImagenes.get(contadorImagen));
                                    }
                                }
                            });
                        }
                        fin.close();
                    }catch (Exception e) {
                        Log.e("Ficheros","Error al leer en la tarjeta");
                    }
                }
            }
        });

        btnBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    private void comprobarBotones() {
        if(contadorImagen == 0) {
            btnAnterior.setEnabled(false);
        }else if (contadorImagen == listaImagenes.size()) {
            btnSiguiente.setEnabled(false);
        }else {
            btnAnterior.setEnabled(true);
            btnSiguiente.setEnabled(true);
        }
    }
}