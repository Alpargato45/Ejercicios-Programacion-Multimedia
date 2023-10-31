package com.example.ejemplolistener;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);

        final TextView etiqueta1 = findViewById(R.id.Lbl1);
        final TextView etiqueta2 = findViewById(R.id.Lbl2);
        final TextView etiqueta3 = findViewById(R.id.Lbl3);
        final TextView etiqueta4 = findViewById(R.id.Lbl4);

        final EditText texto = findViewById(R.id.et);


        texto.addTextChangedListener(new TextWatcher() {
            //Metodo que se usa antes de cambiar el texto
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {
                etiqueta1.setText(charSequence.toString());

                etiqueta3.setText(charSequence.toString() + " start: " + start + " count: " + count + " after: " + after);

            }

            //Metodo que se lanza cuando el texto cambia
            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
                etiqueta2.setText(charSequence.toString());

                etiqueta4.setText(charSequence.toString() + " start: " + start + " before: " + before + " count: " + count);
            }

            @Override
            public void afterTextChanged(Editable editable) {
                //No hago nada
            }
        });



    }

    public void onClick(View view) {
        final TextView etiqueta5 = findViewById(R.id.Lbl5);

        int id = view.getId();
        if (id == R.id.btnAceptar) {
            etiqueta5.setText("Mostrar");
        }else if (id == R.id.btnCancelar) {
            etiqueta5.setText("Ocultar");
        }
    }

}