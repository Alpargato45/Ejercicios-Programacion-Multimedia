package com.example.examentema7parte2jorgedcm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.examentema7parte2jorgedcm.AdaptadorLista.Adaptador;
import com.example.examentema7parte2jorgedcm.AdaptadorLista.Datos;
import com.example.examentema7parte2jorgedcm.AdaptadorSpinner.AdaptadorSpinner;
import com.example.examentema7parte2jorgedcm.AdaptadorSpinner.DatosSpinner;
import com.example.examentema7parte2jorgedcm.ManejoDatos.ContactosProvider;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private int personajeSel = 0;
    private int contactoSeleccionado = 0;
    LinearLayout linearAñadir;
    private Adaptador adaptador;
    private Button btnAñadir;
    private Button btnCancelar;
    private Button btnModificar;
    private ListView lista;
    private EditText editNombre;
    private EditText editTelefono;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);

        final ImageView imgAñadirPersona = findViewById(R.id.imgAñadirPersona);
        linearAñadir = findViewById(R.id.layoutAñadirModificar);
        btnAñadir = findViewById(R.id.btnAñadir);
        btnCancelar = findViewById(R.id.btnCancelar);
        btnModificar = findViewById(R.id.btnModificar);

        editNombre = findViewById(R.id.editTextNombre);
        editTelefono = findViewById(R.id.editTextTelefono);

        lista = findViewById(R.id.listViewPersonajes);
        registerForContextMenu(lista);

        spinner = findViewById(R.id.spinnerImagenes);
        DatosSpinner[] datosSpinners = new DatosSpinner[] {
            new DatosSpinner(R.drawable.batman),
            new DatosSpinner(R.drawable.capi),
            new DatosSpinner(R.drawable.hulk),
            new DatosSpinner(R.drawable.deadpool),
            new DatosSpinner(R.drawable.furia),
            new DatosSpinner(R.drawable.ironman),
            new DatosSpinner(R.drawable.lobezno),
            new DatosSpinner(R.drawable.spiderman),
            new DatosSpinner(R.drawable.thor),
            new DatosSpinner(R.drawable.wonderwoman),
        };

        rellenarLista();

        AdaptadorSpinner miAdaptador = new AdaptadorSpinner(this,datosSpinners);
        spinner.setAdapter(miAdaptador);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                personajeSel = ((DatosSpinner) parent.getItemAtPosition(position)).getImagen();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {}});
        imgAñadirPersona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vaciarTextos();
                linearAñadir.setVisibility(View.VISIBLE);
                btnAñadir.setVisibility(View.VISIBLE);
            }
        });

        btnAñadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues values = new ContentValues();
                values.put(ContactosProvider.Contactos.COL_NOMBRE,editNombre.getText().toString());
                values.put(ContactosProvider.Contactos.COL_TELEFONO,editTelefono.getText().toString());
                values.put(ContactosProvider.Contactos.COL_PERSONAJE,personajeSel);

                ContentResolver contentResolver = getContentResolver();
                contentResolver.insert(ContactosProvider.CONTENT_URI, values);
                vaciarTextos();
                rellenarLista();
                ocultarLayout();
            }
        });

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ocultarLayout();
            }
        });

        btnModificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues values = new ContentValues();
                values.put(ContactosProvider.Contactos.COL_NOMBRE, editNombre.getText().toString());
                values.put(ContactosProvider.Contactos.COL_TELEFONO, editTelefono.getText().toString());
                values.put(ContactosProvider.Contactos.COL_PERSONAJE, personajeSel);

                ContentResolver contentResolver = getContentResolver();
                contentResolver.update(ContactosProvider.CONTENT_URI,values,ContactosProvider.Contactos._ID + "=" + contactoSeleccionado, null);
                vaciarTextos();
                rellenarLista();
            }
        });

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                contactoSeleccionado = ((Datos) adaptador.getItem(position)).getIndice();
                Toast.makeText(MainActivity.this, "funciona " + contactoSeleccionado, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_contextual, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        int position = info.position;
        Datos contacto = adaptador.getItem(position);
        contactoSeleccionado = contacto.getIndice();

        if(item.getItemId() == R.id.borrarItem) {
            ContentResolver cr = getContentResolver();
            cr.delete(ContactosProvider.CONTENT_URI, ContactosProvider.Contactos._ID + "=" + contactoSeleccionado, null);
            rellenarLista();
            return true;
        }else if (item.getItemId() == R.id.actualizarItem) {
            editNombre.setText(contacto.getNombre().toString());
            int posicionPersonaje = obtenerPosicionPersonaje(contacto.getPersonaje());
            spinner.setSelection(posicionPersonaje);
            editTelefono.setText(contacto.getTelefono().toString());

            linearAñadir.setVisibility(View.VISIBLE);
            btnAñadir.setVisibility(View.GONE);
            btnModificar.setVisibility(View.VISIBLE);
            rellenarLista();
            return true;
        }
        return super.onContextItemSelected(item);
    }

    private int obtenerPosicionPersonaje(int personaje) {
        AdaptadorSpinner adapter = (AdaptadorSpinner) spinner.getAdapter();
        for (int i = 0; i < adapter.getCount(); i++) {
            if (adapter.getItem(i).getImagen() == personaje) {
                return i;
            }
        }
        return 0;
    }

    private void ocultarLayout() {
        linearAñadir.setVisibility(View.GONE);
        btnAñadir.setVisibility(View.GONE);
        btnModificar.setVisibility(View.GONE);
    }

    private void vaciarTextos() {
        editNombre.setText("");
        editTelefono.setText("");
    }

    private void rellenarLista() {
            String[] columnas = new String[]{
                    ContactosProvider.Contactos._ID,
                    ContactosProvider.Contactos.COL_NOMBRE,
                    ContactosProvider.Contactos.COL_TELEFONO,
                    ContactosProvider.Contactos.COL_PERSONAJE,
            };
            Uri versionesUri = ContactosProvider.CONTENT_URI;
            ContentResolver cr = getContentResolver();
            Cursor cur = cr.query(versionesUri, columnas, null,null,null);
            Datos objetoDato;

            ArrayList<Datos> datos = new ArrayList<Datos>();
            adaptador = new Adaptador(this,datos);
            if (cur != null) {
                if (cur.moveToFirst()) {
                    int colId = cur.getColumnIndex(ContactosProvider.Contactos._ID);
                    int colNom = cur.getColumnIndex(ContactosProvider.Contactos.COL_NOMBRE);
                    int colTel = cur.getColumnIndex(ContactosProvider.Contactos.COL_TELEFONO);
                    int colPer =cur.getColumnIndex(ContactosProvider.Contactos.COL_PERSONAJE);

                    do {
                        int id = cur.getInt(colId);
                        String nombre = cur.getString(colNom);
                        String telefono=cur.getString(colTel);
                        int personaje = cur.getInt(colPer);
                        objetoDato = new Datos(id, nombre,telefono,personaje);
                        datos.add(objetoDato);
                    } while (cur.moveToNext());
                }
            }
            lista.setAdapter(adaptador);
    }
}