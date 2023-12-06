package com.example.ejemplomenucontextuallistas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);

        //Recupero el id del listado
        listado = findViewById(R.id.listado);

        //Creo los datos
        ArrayList<String> datos = new ArrayList<String>();
        datos.add("Elemento 1");
        datos.add("Elemento 2");
        datos.add("Elemento 3");
        datos.add("Elemento 4");

        // Creo el adaptador

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,datos);
        listado.setAdapter(adaptador);

        registerForContextMenu(listado);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater inflater = getMenuInflater();
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;

        menu.setHeaderTitle(listado.getAdapter().getItem(info.position).toString().toUpperCase());

        switch (info.position){
            case 0:
                inflater.inflate(R.menu.menu_contextual1,menu);
                break;
            case 2:
                inflater.inflate(R.menu.menu_contextual2,menu);
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        String texto;
        int id = item.getItemId();

        //Realizo una acción aprtiendo dele elemento del menú que he pulsado
        if(id == R.id.mn1Op1 || id == R.id.mn1Op2 || id == R.id.mn1Op3 || id == R.id.mn2Op1) {
            texto = item.getTitle().toString();
            Toast.makeText(this, texto, Toast.LENGTH_SHORT).show();
        }

        //Obtengo información del elemento sobre el que hemos desplegado el menú
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int pulsado = info.position;
        texto = listado.getItemAtPosition(pulsado).toString();
        Toast.makeText(this, texto, Toast.LENGTH_SHORT).show();

        return super.onContextItemSelected(item);
    }
}