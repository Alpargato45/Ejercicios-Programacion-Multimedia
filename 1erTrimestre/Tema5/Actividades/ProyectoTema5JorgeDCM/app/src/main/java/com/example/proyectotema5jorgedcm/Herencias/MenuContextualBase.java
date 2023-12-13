package com.example.proyectotema5jorgedcm.Herencias;

import androidx.annotation.NonNull;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.proyectotema5jorgedcm.R;

public abstract class MenuContextualBase extends MenuBase {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater inflater = getMenuInflater();
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;

        //menu.setHeaderTitle(listado.getAdapter().getItem(info.position).toString().toUpperCase());

        inflater.inflate(R.menu.menu_listview,menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        String texto = "";
        int id = item.getItemId();

        if(id == R.id.mnOpCambioColor) {
            texto = item.getTitle().toString();
            Toast.makeText(this, texto, Toast.LENGTH_SHORT).show();
        }

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int pulsado = info.position;
        //texto = listado.getItemAtPosition(pulsado).toString();
        Toast.makeText(this, texto, Toast.LENGTH_SHORT).show();

        return super.onContextItemSelected(item);
    }
}