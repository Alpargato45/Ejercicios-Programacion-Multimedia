package com.example.ejemplocontrolesbasicos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Busco el id de la etiqueta
        final TextView etiqueta1 = findViewById(R.id.lbl1);
        final TextView etiqueta7 = findViewById(R.id.lbl7);

        String texto = etiqueta1.getText().toString();
        etiqueta7.setText(texto + " copiado de etiqueta1");


        //------------------------ EJEMPLO BOTONES -----------------------------

        final TextView etiquetaBoton = findViewById(R.id.txtBtn);
        final Button miBoton = findViewById(R.id.btn1);

        miBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etiquetaBoton.setText("Pulsado botón simple");
            }
        });

        //Creamos el manejador del Toggle Botton
        final ToggleButton miToggleButton = findViewById(R.id.toggleBtn);

        miToggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    etiquetaBoton.setText("ToggleButton activado");
                }else {
                    etiquetaBoton.setText("ToggleButton desactivado");
                }
            }
        });

        // ImageButton
        final ImageButton img = findViewById(R.id.imgBtn);

        //Establecemos una imagen desde java en el segundo botón
        final ImageButton img2 = findViewById(R.id.imgBtn2);
        img2.setImageResource(R.drawable.pulsa);

        //Creo el manejador de eventos para imgBtn2

        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Cambio la imagen de imgBtn1
                img.setImageResource(R.drawable.feliz);
            }
        });


        //---------Añado Imágenes--------------

        final ImageView imagen = findViewById(R.id.img2);
        imagen.setImageResource(R.drawable.android);

        //--------Auto complete text view --------
        //creamos los datos

        String[] opciones = {"Opcion1","Opcion2","Opcion3","Opcion4","Opcion5"};
        final AutoCompleteTextView textoleido = findViewById(R.id.acText);
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, opciones);
        textoleido.setAdapter(adaptador);


    }
}