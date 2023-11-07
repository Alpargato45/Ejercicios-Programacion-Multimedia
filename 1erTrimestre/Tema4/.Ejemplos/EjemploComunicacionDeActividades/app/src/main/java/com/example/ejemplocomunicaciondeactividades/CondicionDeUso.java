package com.example.ejemplocomunicaciondeactividades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class CondicionDeUso extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_condicion_de_uso);

        //Recupero los elementos del layout
        final TextView lblMensaje = findViewById(R.id.lblMensaje);

        //Obtengo la información del Intent
        Bundle extras = getIntent().getExtras();
        String usuario = extras.getString("usuario");

        //Muestra el saludo en la etiqueta
        String mensaje = "Hola " + usuario + ". ¿Acepta las condiciones de uso?";
        lblMensaje.setText(mensaje);
    }

    public void onClick(View view) {

        Intent intent = new Intent();

        //Comprobamos que vista (botón) ha invocado al método

        int id = view.getId();
        if (id == R.id.btnAceptar) {
            intent.putExtra("boton_pulsado","Aceptar");
            setResult(RESULT_OK, intent);
        }else if (id == R.id.btnRechazar) {
            intent.putExtra("boton_pulsado","Rechazar");
            setResult(RESULT_OK, intent);
        }

        finish();
    }
}