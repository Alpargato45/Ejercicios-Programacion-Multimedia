package com.example.examentema5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PedirCita extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedir_cita);

        TextView texto = findViewById(R.id.textoCita);
        Button boton = findViewById(R.id.botonCita);

        Bundle extras = getIntent().getExtras();
        String dia = extras.getString("dia");
        texto.setText("Pidiendo cita para el " + dia);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PedirCita.this,MainActivity.class);
                intent.putExtra("mensaje", "Cita Pedida");
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}