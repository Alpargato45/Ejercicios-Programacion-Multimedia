package com.example.ejercicio12tema3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.GridLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);


        //Variables
        final Button botonReseteo = findViewById(R.id.BtnResetear);
        final Button botonAceptar = findViewById(R.id.BtnAceptar);
        final GridLayout AficionesColumna = findViewById(R.id.AficionesColumnas);
        final RadioGroup GroupGenero = findViewById(R.id.RadioGroupGenero);
        final RadioGroup GroupDeporte = findViewById(R.id.RadioGroupDeporte);
        final TextView textoFinal = findViewById(R.id.TextoFinal);

        //Botón de Aceptar
        botonAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < AficionesColumna.getChildCount(); i++) {
                    View childView = AficionesColumna.getChildAt(i);
                    if (childView instanceof CheckBox) {
                        CheckBox checkBox = (CheckBox) childView;
                        if (checkBox.isChecked()) {
                            textoFinal.append("\n" + checkBox.getText());
                        }
                    }
                }

                    RadioButton botonElegidoGenero = findViewById(GroupGenero.getCheckedRadioButtonId());
                    textoFinal.append( "\n" + botonElegidoGenero.getText());

                    RadioButton botonElegidoDeporte = findViewById(GroupDeporte.getCheckedRadioButtonId());
                    textoFinal.append( "\n" + botonElegidoDeporte.getText());

            }
        });


        //Botón de Reseteo
        botonReseteo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Resetear las CheckBox
                for (int i = 0; i < AficionesColumna.getChildCount(); i++) {
                    View childView = AficionesColumna.getChildAt(i);
                    if (childView instanceof CheckBox) {
                        CheckBox checkBox = (CheckBox) childView;
                        checkBox.setChecked(false);
                    }
                }
                //Resetear los radiosGroup

                if(GroupGenero != null) {
                    GroupGenero.clearCheck();
                }
                if(GroupDeporte != null) {
                    GroupDeporte.clearCheck();
                }
                //Resetear el texto final
                textoFinal.setText("");
            }
        });




    }
}