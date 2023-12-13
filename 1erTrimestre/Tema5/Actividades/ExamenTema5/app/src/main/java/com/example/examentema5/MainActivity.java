package com.example.examentema5;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private View vista;
    private TextView textoPrincipio;
    private ListView listView;
    private GridView gridView;
    private Spinner spinner;
    private ActivityResultLauncher resultLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textoPrincipio = findViewById(R.id.textoPrincipio);
        vista = findViewById(R.id.vistaPadre);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        listView = findViewById(R.id.listView);
        gridView = findViewById(R.id.gridView);
        spinner = findViewById(R.id.spinner);

        ArrayList<String> datos = new ArrayList<>();
        datos.add("Lunes");
        datos.add("Martes");
        datos.add("Miércoles");
        datos.add("Jueves");
        datos.add("Viernes");
        datos.add("Sábado");
        datos.add("Domingo");

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,datos);
        ArrayAdapter<String> adaptadorSpinner = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,datos);
        listView.setAdapter(adaptador);
        gridView.setAdapter(adaptador);
        spinner.setAdapter(adaptadorSpinner);
        registerForContextMenu(listView);

        resultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                if(result.getResultCode() == Activity.RESULT_OK) {
                    Intent intent = result.getData();
                    if (intent!= null) {
                        Bundle extras = intent.getExtras();
                        String dia = extras.getString("mensaje");
                        Toast.makeText(MainActivity.this, dia, Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
        menu.setHeaderTitle(listView.getAdapter().getItem(info.position).toString());
        if(info.position == 0) {
            inflater.inflate(R.menu.menu_contextual,menu);
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.crearCita) {
            Intent intent = new Intent(MainActivity.this,PedirCita.class);
            intent.putExtra("dia","Lunes");
            resultLauncher.launch(intent);
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_principal,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int opcion = item.getItemId();

        if(opcion == R.id.intent || opcion == R.id.listado) {
            textoPrincipio.setText("");
            listView.setVisibility(View.INVISIBLE);
            gridView.setVisibility(View.INVISIBLE);
            spinner.setVisibility(View.INVISIBLE);
        }else if(opcion == R.id.MnOpImplicito) {
            textoPrincipio.setText("Enviando Correo");
            mandarCorreo(vista);
        }else if(opcion == R.id.MnOpExplicito) {
            textoPrincipio.setText("Ejecutando Intent Explícito");
            Intent intent = new Intent(MainActivity.this,IntentExplicito.class);
            startActivity(intent);
        }else if(opcion == R.id.MnOpListView) {
            textoPrincipio.setText("Creando lista con ListView");
            listView.setVisibility(View.VISIBLE);
        }else if(opcion == R.id.MnOpgridView) {
            textoPrincipio.setText("Creando lista con GridView");
            gridView.setVisibility(View.VISIBLE);
        }else if(opcion == R.id.MnOpSpinner) {
            textoPrincipio.setText("Creando lista con Spinner");
            spinner.setVisibility(View.VISIBLE);
        }
        return super.onOptionsItemSelected(item);
    }

    public void mandarCorreo(View view){
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT,"examen t5");
        intent.putExtra(Intent.EXTRA_TEXT,"Jorge. Intent implícito OK");
        intent.putExtra(Intent.EXTRA_EMAIL, new
                String[]{"rbaebar562@g.educaand.es"});
        startActivity(intent);
    }
}