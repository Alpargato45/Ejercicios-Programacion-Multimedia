package com.example.trucootrato;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);

        final Spinner spinner = findViewById(R.id.spinner);
        final String[] values = {"Truco", "Trato"};
        final ImageButton btn = findViewById(R.id.btn);
        final LinearLayout linearLayout = findViewById(R.id.layoutPrincipal);
        spinner.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,values));

        ActivityResultLauncher resultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                if(result.getResultCode() == Activity.RESULT_OK) {
                    Intent intent = result.getData();

                    if (intent != null) {
                        Bundle extras = intent.getExtras();
                        if (extras!= null) {
                            String fondo = extras.getString("textoElegido");
                            if(fondo.equals("fantasma")) {
                                btn.setBackgroundResource(R.drawable.fantasma);
                                linearLayout.setBackgroundColor(Color.parseColor("#ff8000"));
                            }else if (fondo.equals("calabaza")) {
                                btn.setBackgroundResource(R.drawable.calabaza);
                                linearLayout.setBackgroundColor(Color.parseColor("#ff8000"));
                            }
                            if (fondo.equals("activado")) {
                                linearLayout.setBackgroundResource(R.drawable.fondo6);
                            } else {
                                linearLayout.setBackgroundColor(Color.parseColor("#ff8000"));
                            }
                            }
                        }
                    }
                }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentTrato = new Intent(MainActivity.this,SegundaVentana.class);
                Intent intentTruco = new Intent(MainActivity.this,TerceraVentana.class);
                if(spinner.getSelectedItem().equals("Truco")) {
                    resultLauncher.launch(intentTruco);
                }
                else if (spinner.getSelectedItem().equals("Trato")) {
                    resultLauncher.launch(intentTrato);
                }
            }
        });
    }
}