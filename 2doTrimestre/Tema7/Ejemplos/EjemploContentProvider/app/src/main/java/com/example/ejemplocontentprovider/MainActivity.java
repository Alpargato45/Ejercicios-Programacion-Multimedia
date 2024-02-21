package com.example.ejemplocontentprovider;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Elementos del layout
    private Button btnInsertar;
    private Button btnBorrar;
    private Button btnConsultar;
    private Button btnLlamadas;
    private TextView txtResultados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);

        //Referencias de los controles
        btnInsertar = findViewById(R.id.btnInsertar);
        btnBorrar = findViewById(R.id.btnBorrar);
        btnConsultar = findViewById(R.id.btnConsultar);
        btnLlamadas = findViewById(R.id.btnLlamadas);
        txtResultados = findViewById(R.id.lblResultados);

        btnConsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Columnas a recuperar
                String[] columnas={
                        ClientesProvider.Clientes._ID,
                        ClientesProvider.Clientes.COL_NOMBRE,
                        ClientesProvider.Clientes.COL_TELEFONO,
                        ClientesProvider.Clientes.COL_EMAIL,
                };

                Uri clientesUri = ClientesProvider.CONTENT_URI;
                ContentResolver cr = getContentResolver();

                //Hacemos la consulta
                Cursor cur = cr.query(clientesUri,
                        columnas,                 //columnas a devolver
                        null,                     //condición de la consulta
                        null,                     //argumentos de la consulta
                        null                      //Orden de los resultados
                );

                if (cur.moveToFirst()) {
                    String nombre;
                    String telefono;
                    String email;

                    int colNombre = cur.getColumnIndex(ClientesProvider.Clientes.COL_NOMBRE);
                    int colTelefono = cur.getColumnIndex(ClientesProvider.Clientes.COL_TELEFONO);
                    int colEmail = cur.getColumnIndex(ClientesProvider.Clientes.COL_EMAIL);

                    txtResultados.setText("");
                    do {
                        nombre = cur.getString(colNombre);
                        telefono = cur.getString(colTelefono);
                        email = cur.getString(colEmail);

                        txtResultados.append(nombre + " - " + telefono + " - " + email);
                    }while(cur.moveToNext());
                }
            }
        });

        //Inserto datos con el content resolver
        btnInsertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ContentValues registro = new ContentValues();
                registro.put(ClientesProvider.Clientes.COL_NOMBRE, "Cliente nuevo");
                registro.put(ClientesProvider.Clientes.COL_TELEFONO, "999111222");
                registro.put(ClientesProvider.Clientes.COL_EMAIL, "nuevo@gmail.com");

                ContentResolver cr = getContentResolver();
                cr.insert(ClientesProvider.CONTENT_URI, registro);
            }
        });

        //Borro datos del content provider con el content resolver

        btnBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentResolver cr = getContentResolver();
                cr.delete(ClientesProvider.CONTENT_URI, ClientesProvider.Clientes.COL_NOMBRE + "= 'Cliente nuevo'", null);
            }
        });



    }
}