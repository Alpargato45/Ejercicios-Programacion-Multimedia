package com.example.ejemplocontroles2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spiner);

        //-------Ejemplo Spinner--------
        final Spinner spinner = findViewById(R.id.spinner);
        String[] valores = {"Valor 1", "Valor 2", "Valor 3", "Valor 4", "Valor 5"};

        spinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,valores));

        final TextView texto = findViewById(R.id.text1);
        String valor = spinner.getSelectedItem().toString();
        texto.setText(valor);

        //Creo un manejador de eventos para que cuando cambie mi opcion lo pille
          //Creo un adapter para poder usarlo con el manejador de eventos
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adaptador, View view, int i, long l) {
                String cadena = (String) adaptador.getItemAtPosition(i);
                texto.setText(cadena);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        //Creo el adaptador para el segundo spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.valores, android.R.layout.simple_spinner_item);

        final Spinner spinner2 = findViewById(R.id.spiner2);
        spinner2.setAdapter(adapter);

    }
}